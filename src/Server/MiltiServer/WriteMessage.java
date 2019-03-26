package Server.MiltiServer;

import java.io.*;
import java.net.Socket;

public class WriteMessage extends Thread {

    private BufferedWriter out;
    private BufferedReader console;

    public WriteMessage(Socket socket){
        try {
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            console = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            e.printStackTrace();
        }
        start();
    }

    @Override
    public void run() {
        try {

            while (true){

                String message = console.readLine();

                out.write(message);
                out.newLine();
                out.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
