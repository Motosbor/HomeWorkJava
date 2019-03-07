package Files.ConsolFileWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;




public class WorkWithFiles {


    public static String modificator(String file, int count){


        int splitFirst = file.lastIndexOf('.');

        String counter = "("+count+")";

        String modificated = file.substring(0,splitFirst) + counter;

        int splitSecond = file.length();

        String extension = file.substring(splitFirst,splitSecond);

        String result = modificated + extension;

        return result;

    }

    public static void deleteFile(String nameFile){
        Path path = Paths.get(nameFile);
        if (Files.exists(path)){
            try {
                Files.delete(path);
                System.out.println("Файл " + nameFile + " удален");
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            System.out.println("Файл не найден");
        }

    }



    public static void copyFile(String nameFile, String sourceFile) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path sourcePath = Paths.get(sourceFile);
        if (Files.exists(sourcePath)) {
            int count = 1;
            String keep = nameFile;
            Path path = Paths.get(nameFile);
            if (Files.exists(path)) {
                System.out.println("Файл уже с таким именем существует, создать копию (Y/N) ?");
                try {
                    String in = reader.readLine();
                    if (in.equals("Y")) {
                        while (Files.exists(path)) {
                            String modified = modificator(nameFile,count);
                            path = Paths.get(modified);
                            nameFile = keep;
                            count++;
                        }
                        Files.copy(sourcePath,path);
                        System.out.println("Копия файла создана под именем - " + path.toString());
                    } else if (in.equals("N")){
                        System.out.println("Копия не была создана");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                try {
                    Files.copy(sourcePath,path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else {
            System.out.println("Файл источник не найден");
        }
    }
}
