package Server.Shakespeare;

import java.io.*;
import java.net.Socket;


public class Client {

    private static Socket clientSocket;
    private static BufferedReader in;

    public static void main(String[] args) {

        String str;
        try {

            clientSocket = new Socket("localhost",1616);

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            while ((str=in.readLine())!=null){
                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Закрытие клиента");
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

