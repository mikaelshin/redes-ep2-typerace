package br.usp.each.typerace.client;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class Client extends WebSocketClient {

    private int id;
    private int points;

    public Client(URI serverUri, int id) {

        super(serverUri);
        this.id = id;
    }

    public int getId() {

        return this.id;
    }

    public int getPoints() {

        return this.points;
    }

    public void setPoints(int points) {

        this.points = points;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        // TODO: Implementar
    }

    @Override
    public void onMessage(String message) {
        // TODO: Implementar
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
