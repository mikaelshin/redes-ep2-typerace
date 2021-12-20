package br.usp.each.typerace.server;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import java.net.InetSocketAddress;
import java.util.*;

public class Server extends WebSocketServer {

    private static int nConnections = 0;
    private static int id = 0;
    private static boolean gameStarted = false;
    private final Map<String, WebSocket> connections;
    private List<String> wordsList = TypeRace.getWordsList(20);
    private Map<String, List<String>> currentWordsList = new HashMap<>();

    public Server(int port, Map<String, WebSocket> connections) {
        super(new InetSocketAddress(port));
        this.connections = connections;
    }

    private String getPlayerNick(WebSocket conn) {

        String desc = conn.getResourceDescriptor();
        return desc.substring(desc.indexOf("=") + 1);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        
        if (this.connections.containsKey(getPlayerNick(conn))) {

            conn.send("\nNick already used. Please, type another one.\n");
            conn.close(1001);
        
        } else {

            String playerNick = getPlayerNick(conn);
            this.connections.put(playerNick, conn);
            Player player = new Player(id++, playerNick, 0);
            List<String> copyWordsList = new ArrayList<>();
            copyWordsList.addAll(wordsList);
    
            currentWordsList.put(player.getNick(), copyWordsList);
        }
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        
        if (code != 1001) {

            String playerNick = getPlayerNick(conn);
            this.connections.remove(playerNick);
            broadcast("\n" + playerNick + " has quit.\n");
        }
    }

    @Override
    public void onMessage(WebSocket conn, String message) {

        if (message.equals("estabilishingConnection")) {

            conn.send("\nConnection estabilished successfully!\nPress \"Enter\" to get ready the game or wait for more players.");
            broadcast("Number of player(s): " + this.connections.size());
            return;
        }

        nConnections++; 
            
        if (this.connections.size() == nConnections && message.equals("start")) {

            startGameMessage();
            broadcastWordsList();
            gameStarted = true;
        }

        if (gameStarted && !message.equals("start")) {

            String currentPlayerNick = getPlayerNick(conn);
            Player currentPlayer = getCurrentPlayer(currentPlayerNick);

            if (message.equalsIgnoreCase(currentWordsList.get(currentPlayerNick).get(0)))
                currentPlayer.setPoints();              
            
            currentWordsList.get(currentPlayerNick).remove(0);

            sendWordsList(conn, currentWordsList.get(currentPlayerNick));
            
            if(currentWordsList.get(currentPlayerNick).isEmpty()) {
                getPlacing();
                broadcast("gameover");
                System.exit(0);
            }
        }

    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        
        ex.printStackTrace();
    }

    @Override
    public void onStart() {
        
        System.out.println("Server initialized in " + getPort());
    }

    private void startGameMessage() {

        try {
            
            broadcast("The game will start!");

            for (int cont = 5; cont > 0; cont--) {
                
                Thread.sleep(1000);

                if (cont >= 3) 
                    broadcast(cont - 2 + "");
                
                if (cont == 2) 
                    broadcast("Ready...");

                if (cont == 1) 
                    broadcast("Go!");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private Player getCurrentPlayer(String nick) {

        Map<String, Player> instances = Player.getInstances();

        for (String key : instances.keySet())
            if (key.equals(nick)) 
                return instances.get(key);

        return null;
    }

    private void broadcastWordsList() {

        String words = "";

        for (String word : this.wordsList)
            words += "  " + word;   

        broadcast(words);
    }

    private void sendWordsList(WebSocket conn, List<String> wordsList) {

        String words = "";
        System.out.println("\n");

        for (String word : wordsList)
            words += "  " + word;   

        conn.send(words);
    }

    private void getPlacing() {

        String print = "\nPlacing: \n";
        String ordinal = "";
        Map<String, Player> instances = Player.getInstances();
        Map<String, Integer> playerNickAndPoints = new HashMap<>();
        LinkedHashMap<String, Integer> classification = new LinkedHashMap<>();

        for (String key : instances.keySet()) {
            Player player = instances.get(key);
            playerNickAndPoints.put(player.getNick(), player.getPoints());
        }

        playerNickAndPoints.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .forEachOrdered(x -> classification.put(x.getKey(), x.getValue()));  

        int place = this.connections.size();

        for (Map.Entry<String, Integer> entry : classification.entrySet()) {

            if (place == 3)
                ordinal = "rd";
            else if (place == 2)
                ordinal = "nd";
            else if (place == 1)
                ordinal = "st";
            else 
                ordinal = "th";

            print += place + ordinal + " Place: " + entry.getKey() + " (" + entry.getValue() + " points) \n";
            place--;
        }

        broadcast(print);
    }

}
