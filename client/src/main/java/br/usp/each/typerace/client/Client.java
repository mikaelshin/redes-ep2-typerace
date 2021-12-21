package br.usp.each.typerace.client;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;

public class Client extends WebSocketClient {
    

    public Client(URI serverUri) {

        super(serverUri);
        ClientMain.flagConnected = true;
        ClientMain.flagGameOver = false;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        
        send("estabilishingConnection"); 
    }

    @Override
    public void onMessage(String message) {

        if (message.equals("gameover")) {

            System.out.println("\nGame Over!");
            System.exit(0);
        }
        else 
            System.out.println(message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {

        if (code == 1001)
            ClientMain.flagConnected = false;
        
        else {
            System.out.println("\nHope see you soon. Bye!");
            System.exit(0);
        }
    }

    @Override
    public void onError(Exception ex) {

        ex.printStackTrace();
    }

}
