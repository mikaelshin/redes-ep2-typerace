package br.usp.each.typerace.server;

import org.java_websocket.server.WebSocketServer;
import java.util.HashMap;
import java.util.List;

public class ServerMain {

    private WebSocketServer server;

    public ServerMain(WebSocketServer server) {
        this.server = server;
    }

    public WebSocketServer getServer() {

        return this.server;
    }

    public void init() {

        server.start();
    }

    public static void main(String[] args) {

        WebSocketServer server = new Server(8081, new HashMap<>());
//        List<String> wordsList = TypeRace.getWordsListFromFile(20);

        ServerMain main = new ServerMain(server);

        main.init();
    }

}
