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
    private static String line = "--------------------------------------------";

    public Server(int port, Map<String, WebSocket> connections) {
        super(new InetSocketAddress(port));
        this.connections = connections;
    }

    private String getPlayerId(WebSocket conn) {

        String descriptor = conn.getResourceDescriptor();
        return descriptor.substring(descriptor.indexOf("=") + 1);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        
        String playerNick = getPlayerId(conn);
        this.connections.put(playerNick, conn);
        Player player = new Player(id++, playerNick, 0);
        List<String> copyWordsList = new ArrayList<>();
        copyWordsList.addAll(wordsList);
        currentWordsList.put(player.getNick(), copyWordsList);
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        // TODO: Implementar
    }

    @Override
    public void onMessage(WebSocket conn, String message) {

        if (message.equals("estabilishingConnection")) {

            conn.send("Connection estabilished successfully.");
            return;
        }

        nConnections++; 
            
        if (this.connections.size() == nConnections && message.equals("start")) {

            startGameMessage();
            broadcastWordsList();
            gameStarted = true;
        }

        if (gameStarted && !message.equals("start")) {

            String currentPlayerNick = getPlayerId(conn);
            Player currentPlayer = getCurrentPlayer(currentPlayerNick);

            System.out.println(line);
            System.out.println("Nick: " + currentPlayerNick);
            System.out.println("Id: " + (currentPlayer.getId()) + ", Nick: " + currentPlayer.getNick());
            System.out.println(line);
            System.out.println("Lista Antes " + currentPlayer.getId() + ": " + Arrays.toString(currentWordsList.get(currentPlayerNick).toArray()));
            System.out.println(line);
            
            if (message.equalsIgnoreCase(currentWordsList.get(currentPlayerNick).get(0)))
                currentPlayer.setPoints();              
            System.out.println(line);
            
            System.out.println("o jogador " + currentPlayer.getNick() + " digitou e seu id é " + (currentPlayer.getId()));
            System.out.println("o jogador " + currentPlayer.getNick() + " está com " + currentPlayer.getPoints());

            System.out.println(line);
            
            currentWordsList.get(currentPlayerNick).remove(0);

            System.out.println("Lista Depois " + currentPlayer.getId() + ": " + Arrays.toString(currentWordsList.get(currentPlayerNick).toArray()));
            System.out.println(line);

            sendWordsList(conn, currentWordsList.get(currentPlayerNick));
            
        }

    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        
        ex.printStackTrace();
    }

    @Override
    public void onStart() {
        // TODO: Implementar
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

        words += "\nR: "; 

        conn.send(words);
    }
}
