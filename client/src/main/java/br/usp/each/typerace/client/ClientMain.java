package br.usp.each.typerace.client;

import org.java_websocket.client.WebSocketClient;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ClientMain {

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
        /*
           FIXME: Remover essas strings fixas
           Como podemos fazer para que o cliente receba um parâmetro indicando a qual servidor
           ele deve se conectar e o seu ID?
        */

        try {

            Scanner sc = new Scanner(System.in);
            WebSocketClient client = null;
            
            while (true) {

                String url = "ws://localhost:8081";

                startMenu(sc);

                System.out.println("Type your nickname: ");
                String nick = sc.nextLine();
                
                client = new Client(new URI(url + "/nick=" + nick), nick);
                ClientMain clientMain = new ClientMain(client);
                clientMain.init(nick);
                
                if (client.isOpen())
                    break;
            }

            System.out.println("Type anything to start the game: ");
            sc.nextLine();
            client.send("start");

            while (true) {

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
            
            if (command.equalsIgnoreCase("R")) {
                System.out.println("1. For each typed word correctly, you earns 1 point.");
                System.out.println("2. There's no point discount, even if you miss the word.");
                System.out.println("3. You have 1 minute to type the desired amount of words.");
                System.out.println("4. Have fun!");
            }

            else if (command.equalsIgnoreCase("E")){
                System.out.println("Game Over! \n");
                System.exit(1);
            }

            else if (!command.equalsIgnoreCase("S"))
                System.out.println("Type a valid command! \n");

        } while (!command.equalsIgnoreCase("S"));

    }

    private static String createPlayer(Scanner sc) {

        System.out.println("Type your nickname: ");
        return sc.nextLine();
    }

    private static GameInfo playMenu(Scanner sc) {

        String players = "";
        String words = "";
        String nick = "";
        int nPlayers = 0;
        int nWords = 0;

        try {

            do {
                System.out.println("How many players (1 - 4)? ");
                players = sc.nextLine();
                nPlayers = tryParseInt(players, 0);

                System.out.println("Type your nickname: ");
                nick = sc.nextLine();

                System.out.println("How many words (5 - 150)? ");
                words = sc.nextLine();
                nWords = tryParseInt(words, 0);

                if (nPlayers < 1 || nPlayers > 4)
                    System.out.println("Type a number between 1 - 4 for players!");

                if (nWords < 5 || nWords > 30)
                    System.out.println("Type a number between 5 - 30 for words!");

            } while (nPlayers < 1 || nPlayers > 4 || nWords < 5 || nWords > 150);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return new GameInfo(nick, nPlayers, nWords);
    }

    private static void startGame() {

        try {

            for (int cont = 3; cont >= 1; cont--) {
                System.out.print(cont + " ");
                Thread.sleep(1000);
            }
            System.out.println("\nReady...");
            System.out.println("Go!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static int tryParseInt(String value, int defaultVal) {

        try {

            return Integer.parseInt(value);

        } catch (NumberFormatException e) {

            return defaultVal;
        }
    }


}
