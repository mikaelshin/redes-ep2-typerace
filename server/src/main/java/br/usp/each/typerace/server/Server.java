package br.usp.each.typerace.server;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import java.net.InetSocketAddress;
import java.util.*;
import java.lang.*;
import br.usp.each.typerace.*;

public class Server extends WebSocketServer {

    private int nConnections = 0;
    private boolean gameStarted = false;
    private final Map<String, WebSocket> connections;
    List<String> wordsList = TypeRace.getWordsList(20);
    private String nick;
    private static int id = 0;
    Player player = null;

    public Server(int port, Map<String, WebSocket> connections) {
        super(new InetSocketAddress(port));
        this.connections = connections;
    }

    private String getPlayerId(String resourceDescriptor) {
        return resourceDescriptor.substring(resourceDescriptor.indexOf("nick=") + 5);
    }

    private String getPlayerId(WebSocket conn) {
        return getPlayerId(conn.getResourceDescriptor());
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        
        this.nick = getPlayerId(conn);
        this.connections.put(nick, conn);
        player = new Player(id++, this.nick, 0);
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
            
            String words = "";

            for (String word : this.wordsList)
                words += "  " + word;   

            broadcast(words);
            gameStarted = true;
        }

        if (gameStarted && !message.equals("start")) {

            List<List<String>> list = new ArrayList<>();

            System.out.println("Nick: " + nick);
            list.add(wordsList);
            System.out.println("Id: " + (player.getId() - 1) + ", Nick: " + player.getNick());
            
            System.out.println(Arrays.toString(list.get(player.getId()-1).toArray()));

            if (message.equalsIgnoreCase(list.get(player.getId()-1).get(0)))
                player.setPoints();              
            
            System.out.println("o jogador " + player.getNick() + " digitou e seu id é " + (player.getId() - 1));
            System.out.println("o jogador " + player.getNick() + " está com " + player.getPoints());

            list.get(player.getId()-1).remove(0);
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
}
