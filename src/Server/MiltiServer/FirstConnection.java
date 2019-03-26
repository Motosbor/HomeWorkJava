package Server.MiltiServer;

import java.io.*;
import java.net.Socket;

public class FirstConnection  {

    public static String request = "Введите логин:";
    public static String secondRequest = " Выберите чат 1 - Общий , 2 - Персональный";
    public static String resultLogin;
    public static BufferedReader readFromClient;
    public static BufferedWriter write;

   public FirstConnection(Socket socket){

       try {

           write = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

           write.write(request);
           write.newLine();
           write.flush();
           System.out.println("Запрос логина");

           System.out.println("Ожидание ответа");
           readFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           resultLogin = readFromClient.readLine();
           System.out.println("Ответ получен");

           write.write(secondRequest);
           write.newLine();
           write.flush();

           while (true) {

               String chat = readFromClient.readLine();

               switch (chat) {
                   case "1":
                       MultiConnector serverClient = new MultiConnector(socket, resultLogin);
                       Server.ClientsList.add(serverClient);
                       write.write("Выбран общий чат");
                       write.newLine();
                       write.flush();
                       break; //Создание общего потока для отправки сообщений всем клиентам
                   case "2":
                       PersonalConnector personalConnector = new PersonalConnector(socket, resultLogin);
                       Server.PersonalConnectorList.add(personalConnector);
                       write.write("Выбран персональный чат");
                       write.newLine();
                       write.flush();
                       break;
                       //создание потока для персональной отправки сообщений выбранному клиенту

                   default:
                       write.write("Неверный ввод");
                       write.newLine();
                       write.flush();
               }
               break;
           }


       }catch (IOException e){
           e.printStackTrace();
       }
   }
}
