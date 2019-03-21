package Server.Shakespeare;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {

        FileSearcher fileSearcher = new FileSearcher();
        List<String> sonet = new ArrayList<>(fileSearcher.getSonet());

        try {
            server = new ServerSocket(1616);
            System.out.println("Сервер запущен");
            clientSocket = server.accept();
            try {
                System.out.println("Открываем потоки");

                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                out.write("Сонет Шексприра:" + "\n");
                out.flush();

                for (String s : sonet) {
                    out.write(s + "\n");
                    out.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Закрытие сокета клиента");
                clientSocket.close();
                System.out.println("Закрытие сервера");
                server.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
