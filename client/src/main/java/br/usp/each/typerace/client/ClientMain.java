package br.usp.each.typerace.client;

import org.java_websocket.client.WebSocketClient;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

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

                String nick = createPlayer(sc);
                
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

        } while (!command.trim().equalsIgnoreCase("S"));

    }

    private static String createPlayer(Scanner sc) {

        System.out.println("Type your nickname: ");
        return sc.nextLine();
    }

}
