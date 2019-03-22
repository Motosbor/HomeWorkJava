package Server.Connection;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerClient {

    private static ObjectInputStream in;
    public static BufferedReader reader;


    private Map<String,Socket> sockets = new HashMap<>();


    public void add(Socket socket, String name){
        sockets.put(name,socket);
        Thread thread = new Thread(()->run(socket));
        thread.start();
    }

    private void run(Socket socket){

        reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            try {

            in = new ObjectInputStream(socket.getInputStream());
            Message message = (Message)in.readObject();
            String name = reader.readLine();
            sendIt(message,name);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    public void sendIt(Message message,String name){
        for (Map.Entry<String,Socket> enrty: sockets.entrySet()) {
            if(enrty.getKey().equals(name)){
                try {
                    ObjectOutputStream out = new ObjectOutputStream(enrty.getValue().getOutputStream());
                    out.writeObject(new Message(message.getMessage(),message.getUser()));
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }


    }
}
