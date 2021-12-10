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

     public void init(String idCliente) {
         System.out.println("Iniciando cliente: " + idCliente);
         // TODO: Implementar
     }

    public static void main(String[] args) {
        /*
           FIXME: Remover essas strings fixas
           Como podemos fazer para que o cliente receba um parâmetro indicando a qual servidor
           ele deve se conectar e o seu ID?
        */
        String removeMe = "ws://localhost:8080";
        String removeMe2 = "idCliente";

         try {
             menu();
             WebSocketClient client = new Client(new URI(removeMe));
             ClientMain main = new ClientMain(client);
             main.init(removeMe2);

         } catch (URISyntaxException e) {
             e.printStackTrace();
         }
    }

    private static void menu() {

        Scanner sc = new Scanner(System.in);
        String command = "";

        System.out.println("-------------- Welcome to TypeRace! --------------");

        do {
            System.out.println("Choose a command:");
            System.out.println("[S]: Start game");
            System.out.println("[R]: Rules");
            System.out.println("[E]: Exit");
            command = sc.nextLine();
            
            if (command.equals("R")) {
                System.out.println(" \n");
            }

            else if (command.equals("E")){
                System.out.println("Game Over! \n");
                System.exit(0);
            }
            else
                System.out.println("Type a valid command! \n");

        } while (!command.equals("S"));

        sc.close();
    }
}
