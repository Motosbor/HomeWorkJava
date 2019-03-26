package Server.MiltiServer;

import java.io.*;
import java.net.Socket;

public class FirstConnection  {

    public static PrintWriter write;
    public static String request = "Введите логин:";
    public static String secondRequest = " Выберите чат 1 - Общий , 2 - Персональный";
    public static String resultLogin;
    public static BufferedReader readFromClient;

   public static void FirstConnect(Socket socket){

       try {

           write = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

           write.println(request);
           write.flush();
           System.out.println("Запрос логина");

           System.out.println("Ожидание ответа");
           readFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           resultLogin = readFromClient.readLine();
           System.out.println("Ответ получен");

           write.println(secondRequest);
           write.flush();

           while (true) {

               String chat = readFromClient.readLine();

               switch (chat) {
                   case "1":
                       MultiConnector serverClient = new MultiConnector(socket, resultLogin);
                       Server.ClientsList.add(serverClient);
                       break; //Создание общего потока для отправки сообщений всем клиентам
                   case "2":
                       PersonalConnector personalConnector = new PersonalConnector(socket, resultLogin);
                       Server.PersonalConnectorList.add(personalConnector);
                       break;//создание потока для персональной отправки сообщений выбранному клиенту

                   default:
                       write.println("Неверный ввод");
                       write.flush();
               }
           }


       }catch (IOException e){
           e.printStackTrace();
       }
   }
}
