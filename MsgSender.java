package simplechat;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Created by hoanbka on 20-Sep-16.
 */

public class MsgSender extends Thread {
    private ObjectOutputStream outputStream;
    private String userName;
    private Scanner scanner;

    public MsgSender(String userName, ObjectOutputStream outputStream) {
        this.outputStream = outputStream;
        this.userName = userName;
        scanner = new Scanner(System.in);
    }

    @Override
    public void run() {

        String msg;
        try {
            while (true) {
                msg = scanner.nextLine();
                outputStream.writeObject(new Message(msg, userName));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}