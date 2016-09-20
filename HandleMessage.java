package simplechat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by hoanbka on 20-Sep-16.
 */

public class HandleMessage extends Thread {
    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private ArrayList<ObjectOutputStream> listClient;

    public HandleMessage(Socket socket, ArrayList listClient) {
        this.socket = socket;
        this.listClient = listClient;
        try {
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            listClient.add(outputStream);
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message message = (Message) inputStream.readObject();
                broadCast(message);
                display(message);
            }
        } catch (IOException | ClassNotFoundException ex) {
           ex.printStackTrace();
        }
    }

    public void broadCast(Message message) {
        try {
            for (ObjectOutputStream client : listClient) {
                client.writeObject(message);
                client.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void display(Message message) {
        System.out.println(message.getUserName() + ": " + message.getContent());
    }

}