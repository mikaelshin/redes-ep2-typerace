package br.usp.each.typerace.server;

import org.java_websocket.server.WebSocketServer;
import java.util.HashMap;

public class ServerMain {

    private WebSocketServer server;

    public ServerMain(WebSocketServer server) {
        this.server = server;
    }

    public WebSocketServer getServer() {
        return this.server;
    }

    public void init() {
        this.getServer().onStart();

    }

    public static void main(String[] args) {
        WebSocketServer server = new Server(8080, new HashMap<>());

        ServerMain main = new ServerMain(server);

        main.init();
    }

}
