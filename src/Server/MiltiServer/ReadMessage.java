package Server.MiltiServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadMessage extends Thread {

   private BufferedReader in ;

   public ReadMessage(Socket socket){
       try {
           in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       }catch (IOException e){
           e.printStackTrace();
       }
       start();
   }

    @Override
    public void run() {
        try {
            while (true) {

                String message = in.readLine();
                System.out.println(message);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
