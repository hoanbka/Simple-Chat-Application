package simplechat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by hoanbka on 20-Sep-16.
 */
public class ClientMain {

    private static final String host = "localhost";
    private static final int port = 8088;

    public static void main(String[] args) throws IOException {
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        Socket socketClient = null;
        String userName;
        Scanner scan = new Scanner(System.in);
        System.out.println("userName : ");
        userName = scan.nextLine();

        try {
            socketClient = new Socket(host, port);
            inputStream = new ObjectInputStream(socketClient.getInputStream());
            outputStream = new ObjectOutputStream(socketClient.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        MsgReceiver msgReceiver = new MsgReceiver(inputStream);
        MsgSender msgSender = new MsgSender(userName, outputStream);
        msgReceiver.start();
        msgSender.start();
    }
}