package Server.MiltiServer;
import java.io.*;
import java.net.Socket;
import java.nio.Buffer;


public class Client {


    private static Socket clientSocket;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static BufferedReader reader;
    private static String login;
    private static String choose;


    public static void main(String[] args) {

        try {

            clientSocket = new Socket("localhost",8080);

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out =new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(System.in));

            try {

                System.out.println("Ожидание");
                String inputMessage = in.readLine();
                System.out.println("Сообщение сервера:");
                System.out.print(inputMessage);

                ReadMessage readMessage = new ReadMessage(clientSocket);
                WriteMessage writeMessage = new WriteMessage(clientSocket);


            }catch (IOException e){
                e.printStackTrace();
            }

        }catch (IOException e){
            e.printStackTrace();
            System.err.println("Соединение закрыто");
        }
    }
}