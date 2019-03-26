package Server.MiltiServer;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class PersonalConnector extends Thread {

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private String name;
    private SimpleDateFormat messageTime = new SimpleDateFormat("HH:mm:ss");


    public PersonalConnector(Socket client, String name) {

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

        boolean flag = false;

        while (!flag) {

            try {

                this.out.write("Введите получателя");
                this.out.newLine();
                this.out.flush();


                String target = in.readLine();
                for (PersonalConnector sc : Server.PersonalConnectorList) {

                    if (target.equals(sc.name)) {
                        ChatStart(sc);
                        flag = true;
                    }
                }

                if(!flag){
                    this.out.write("Такого получателя нет");
                    this.out.newLine();
                    this.out.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }



    private void ChatStart(PersonalConnector personalConnector){

        while (true) {

            try {

                String message = in.readLine() ;
                String time = messageTime.format(new Date());
                String toSend ="Время:" + time + " Отправитель:" + this.name + " - " + message;


                personalConnector.out.write(toSend);
                personalConnector.out.newLine();
                personalConnector.out.flush();


            } catch (IOException e) {

                Loging("Покинул чат");
                System.err.println(this.name + " Отключил соединение");
                break;

            }
        }

    }

        private void Loging(String log){

            for (PersonalConnector sc : Server.PersonalConnectorList) {

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

