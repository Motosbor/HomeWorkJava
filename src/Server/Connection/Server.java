package Server.Connection;




import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;


public class Server {

    public static final int PORT = 1616;
    public static LinkedList<ServerClients> serverClients = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        try {
            while (true) {

                Socket socket = server.accept();
                try {
                    serverClients.add(new ServerClients(socket));
                } catch (IOException e) {

                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}

