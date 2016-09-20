package simplechat;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by hoanbka on 20-Sep-16.
 */

public class HandleConnect extends Thread {

    ArrayList<ObjectOutputStream> listClient = null;
    ServerSocket listener = null;

    public HandleConnect(ArrayList listClient, ServerSocket listener) {
        this.listClient = listClient;
        this.listener = listener;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Waiting new client....");
                Socket client = listener.accept();
                System.out.println("New connect!");
                new HandleMessage(client, listClient).start();
                sleep(5);

            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}