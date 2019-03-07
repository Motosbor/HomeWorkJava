package Files.ConsolFileWork;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Reader {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void commander(){


        int command;
        String source;
        String target;
        while (true) {
            System.out.println("Введите команду: 1 - удалить, 2 - переместить, 3 - скопировать");
            System.out.println("Введите имя исходного файла , если выбраны команды 2 или 3 введите имя файла назначения, \n все данные вводить через пробел");
            try {
                String s = reader.readLine();
                String[] splitter = s.split(" ");
                System.out.println(splitter.length);

                if (splitter.length == 3) {
                    command = Integer.parseInt(splitter[0]);
                    source = splitter[1];
                    target = splitter[2];
                    if(command==2){
                        WorkWithFiles.moveFile(source,target);
                    }else if(command==3){
                        WorkWithFiles.copyFile(source,target);
                    }else {
                        System.out.println("Неккоректный ввод");
                        continue;
                    }
                } else if (splitter.length == 2) {
                    command = Integer.parseInt(splitter[0]);
                    source = splitter[1];
                    WorkWithFiles.deleteFile(source);
                } else {
                    System.out.println("Неккоректный ввод");
                    continue;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("Для выхода наберите \"stop\" ");
                if (reader.readLine().equals("stop")) {
                    break;
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }



    }

}
