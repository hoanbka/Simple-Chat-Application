package simplechat;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 * Created by hoanbka on 20-Sep-16.
 */
public class ServerMain {
    private static final int port = 8088;

    public static void main(String[] args) throws IOException {
        ArrayList<ObjectOutputStream> listClient = new ArrayList<>();
        ServerSocket listener = new ServerSocket(port);
        new HandleConnect(listClient, listener).start();

    }
}