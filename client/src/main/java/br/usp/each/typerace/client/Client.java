package br.usp.each.typerace.client;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class Client extends WebSocketClient {

    private String nick;
    private int points;

    public Client(URI serverUri, String nick) {

        super(serverUri);
        this.nick = nick;
    }

    public String getNick() {

        return this.nick;
    }

    public int getPoints() {

        return this.points;
    }

    public void setPoints(int points) {

        this.points = points;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        
        send("estabilishingConnection"); 
    }

    @Override
    public void onMessage(String message) {

        System.out.println(message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        // TODO: Implementar
    }

    @Override
    public void onError(Exception ex) {
        // TODO: Implementar
    }
}
