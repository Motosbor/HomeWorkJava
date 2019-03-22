package Server.Connection;

import Server.Shakespeare.FileSearcher;

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

        try {

        server = new ServerSocket(1616);
        System.out.println("Server START");
        ServerClient serverClient = new ServerClient();
        clientSocket = new Socket();

        while (true) {

            System.out.println("Wait connection");
            clientSocket = server.accept();
            System.out.println("Connection succes");

            PrintWriter outPrint = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            System.out.println("Out stream start");

                outPrint.println("Введите логин");
                outPrint.flush();


            System.out.println("Out stream stop");

            System.out.println("Input stream start");
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String login = in.readLine();
            System.out.println("Input stream success");
            serverClient.add(clientSocket,login);
            System.out.println("Client add to MAP");
        }

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
