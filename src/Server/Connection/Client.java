package Server.Connection;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;


public class Client {

    private static Socket clientSocket;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static BufferedReader reader;
    private static ObjectInputStream inObj;
    private static ObjectOutputStream outObj;
    private static String login;

    public static void main(String[] args) {

        try {


        clientSocket = new Socket("localhost",1616);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String inputMessage = in.readLine();
            System.out.println(inputMessage);
            login = reader.readLine();
            out.write(login);
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }



        Thread threadIn = new Thread(()->{
            try {
                while (true) {
                    inObj = new ObjectInputStream(clientSocket.getInputStream());
                    Message m = (Message) inObj.readObject();
                    System.out.println(m.getUser() + "-" + m.getMessage());
                }
            }catch (IOException e){
                e.printStackTrace();
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        } );
        threadIn.start();


        Thread threadOut = new Thread(()->{

            try {

                String s = reader.readLine();
                Message message = new Message(s,login);
                outObj = new ObjectOutputStream(clientSocket.getOutputStream());
                outObj.writeObject(message);
                outObj.flush();

            }catch (IOException e){
                e.printStackTrace();
            }
        });

        threadOut.start();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
