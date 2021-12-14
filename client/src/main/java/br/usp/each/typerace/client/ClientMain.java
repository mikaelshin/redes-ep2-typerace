package br.usp.each.typerace.client;

import org.java_websocket.client.WebSocketClient;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientMain {

     private WebSocketClient client;

     public ClientMain(WebSocketClient client) {
         this.client = client;
     }

     public void init(String idCliente) {

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

             String url = "ws://localhost:8081";

            //  startMenu(sc);
            //  GameInfo gameInfo = playMenu(sc);

            //  for (int i = 1; i <= gameInfo.getPlayers(); i++) {

                 WebSocketClient client = new Client(new URI(url), 1);
                 ClientMain main = new ClientMain(client);
                //  main.init(gameInfo.getNick().get(i));
                 main.init("1");
                 client.send("teste");
            //  }

             startGame();

         } catch (URISyntaxException e) {

             e.printStackTrace();
             System.out.print(e.getMessage());
         }
    }

    // private static void startMenu(Scanner sc) {

    //     String command = "";

    //     System.out.println("-------------- Welcome to TypeRace! --------------");

    //     do {
    //         System.out.println("Choose a command:");
    //         System.out.println("[S]: Start game");
    //         System.out.println("[R]: Rules");
    //         System.out.println("[E]: Exit");
    //         command = sc.nextLine();
            
    //         if (command.equals("R")) {
    //             System.out.println(" \n");
    //         }

    //         else if (command.equals("E")){
    //             System.out.println("Game Over! \n");
    //             System.exit(1);
    //         }

    //         else if (!command.equals("S"))
    //             System.out.println("Type a valid command! \n");

    //     } while (!command.equals("S"));

    // }

    // private static GameInfo playMenu(Scanner sc) {

    //     String players = "";
    //     String words = "";
    //     List<String> nick = new ArrayList<String>();
    //     int nPlayers = 0;
    //     int nWords = 0;

    //     try {

    //         do {
    //             System.out.print("How many players (1 - 4)? ");
    //             players = sc.nextLine();
    //             nPlayers = tryParseInt(players, 0);

    //             for (int i = 1; i <= nPlayers; i++) {

    //                 System.out.print("Type player " + i + " nickname : ");
    //                 nick.add(sc.nextLine());
    //             }

    //             System.out.println("\nHow many words (5 - 30)? ");
    //             words = sc.nextLine();
    //             nWords = tryParseInt(words, 0);

    //             if (nPlayers < 1 || nPlayers > 4)
    //                 System.out.println("Type a number between 1 - 4 for players!");

    //             if (nWords < 5 || nWords > 30)
    //                 System.out.println("Type a number between 5 - 30 for words!");

    //         } while (nPlayers < 1 || nPlayers > 4 || nWords < 5 || nWords > 30);

    //     } catch (Exception e) {

    //         e.printStackTrace();
    //     }

    //     return new GameInfo(nick, nPlayers, nWords);
    // }

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
