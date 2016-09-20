package simplechat;

import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by hoanbka on 20-Sep-16.
 */

public class MsgReceiver extends Thread {

    private ObjectInputStream inputStream;

    public MsgReceiver(ObjectInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message msg = (Message) inputStream.readObject();
                display(msg);
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void display(Message msg) {
        System.out.println(msg.getUserName() + ": " + msg.getContent());
    }
}