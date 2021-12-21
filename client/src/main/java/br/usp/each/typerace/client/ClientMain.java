package br.usp.each.typerace.client;

import org.java_websocket.client.WebSocketClient;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class ClientMain {

    public static boolean flagConnected;
    public static boolean flagGameOver;

    private WebSocketClient client;

    public ClientMain(WebSocketClient client) {

        this.client = client;
    }

    public void init(String nick) {
        
        try {

            client.connectBlocking();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(System.in);
            WebSocketClient client = null;
            
            while (true) {

                String url = "ws://localhost:8082";

                startMenu(sc);

                String nick = createPlayer(sc);
                
                client = new Client(new URI(url + "/nick=" + nick));
                ClientMain clientMain = new ClientMain(client);
                clientMain.init(nick);
                
                try {

                    Thread.sleep(1000);
                }
                catch(Exception e) {
        
                    e.printStackTrace();
                } 

                if (client.isOpen() && flagConnected)
                    break;
            }

            sc.nextLine();
            client.send("start");

            while (true && !flagGameOver) {

                String in = sc.nextLine();
                client.send(in);
            }

        } catch (URISyntaxException e) {

            e.printStackTrace();
            System.out.print(e.getMessage());
        } 
    }

    private static void startMenu(Scanner sc) {

        String command = "";

        System.out.println("-------------- Welcome to TypeRace! --------------");

        do {
            System.out.println("\nChoose a command:");
            System.out.println("[S]: Start game");
            System.out.println("[R]: Rules");
            System.out.println("[E]: Exit");
            command = sc.nextLine();
            
            if (command.trim().equalsIgnoreCase("R")) {
                System.out.println("1. For each typed word correctly, you earn 1 point.");
                System.out.println("2. There's no point discount, even if you miss the word.");
                System.out.println("3. The game will dispose 30 words to you type it correctly.");
                System.out.println("4. The game will end if one of the players get 10 points. Or else, will end if one of the players type all of the 30 words and the player who writes the most words correctly wins.");
                System.out.println("5. Have fun!");
            }

            else if (command.trim().equalsIgnoreCase("E")){
                System.out.println("\nQuitting the game.");
                System.exit(0);
            }

            else if (!command.equalsIgnoreCase("S"))
                System.out.println("\nType a valid command!");

        } while (!command.trim().equalsIgnoreCase("S"));

    }

    private static String createPlayer(Scanner sc) {

        System.out.println("\nType your nickname: ");
        return sc.nextLine();
    }
}
