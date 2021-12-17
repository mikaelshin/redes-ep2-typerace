package br.usp.each.typerace.server;

import org.java_websocket.server.WebSocketServer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

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

        Scanner sc = new Scanner(System.in);
        WebSocketServer server = new Server(8081, new HashMap<>());
        ServerMain serverMain = new ServerMain(server);
        List<String> wordsList = new ArrayList<>();
        
        serverMain.init();

        while (true) {

            if (sc.nextLine().equalsIgnoreCase("quit"))
                System.exit(0);
        }
    }

}
