package Server.MiltiServer;
import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.*;

public class MultiConnector extends Thread {

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private String name;
    private SimpleDateFormat messageTime = new SimpleDateFormat("HH:mm:ss");


    public MultiConnector(Socket client, String name) {

        System.out.println("Создан серверный коннектор");
        this.socket = client;
        this.name = name;

        try {

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        start();
        Loging("Присоединился к чату");
    }

    @Override
    public void run() {

        while (true) {
            try {

                String message = in.readLine() ;
                String time = messageTime.format(new Date());
                String toSend ="Время:" + time + " Отправитель:" + this.name + " - " + message;

                for (MultiConnector sc : Server.ClientsList) {
                    if (!sc.name.equals(this.name)) {
                        sc.out.write("\n" + toSend);
                        sc.out.newLine();
                        sc.out.flush();
                    }
                }

            } catch (IOException e) {

                Loging("Покинул чат");
                System.err.println(this.name + " Отключил соединение");
                break;

            }
        }
    }


        private void Loging(String log){

            for (MultiConnector sc : Server.ClientsList) {

                if (!sc.name.equals(this.name)) {
                    try {
                        sc.out.write("\n" + this.name + " " + log);
                        sc.out.newLine();
                        sc.out.flush();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }

}

