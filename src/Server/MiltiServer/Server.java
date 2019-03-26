package Server.MiltiServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {

    public static int Port = 8080;
    public static ArrayList<MultiConnector> ClientsList = new ArrayList<>();
    public static ArrayList<PersonalConnector> PersonalConnectorList = new ArrayList<>();
    public static ServerSocket serverSocket;


    public static void main(String[] args) throws IOException {

        try {

            serverSocket = new ServerSocket(Port);
            System.out.println("Сервер запущен");

            while (true) {

                System.out.println("Ожидание подклюения");
                Socket client = serverSocket.accept();
                System.out.println("Подключение успешно");

                FirstConnection firstConnection = new FirstConnection(client);


            }

        }finally {
            serverSocket.close();
        }


    }
}
