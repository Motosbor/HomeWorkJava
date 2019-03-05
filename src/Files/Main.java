package Files;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int count = 1;


    public static void main(String[] args) {
//        Path p1 = Paths.get("C:\\Users\\Rus\\IdeaProjects\\HomeWorkJava\\Letter.txt");
//        try {
//
//            BasicFileAttributes fileAtr = Files.readAttributes(p1, BasicFileAttributes.class);
//            System.out.println("Имя файла - " + p1.getFileName());
//            System.out.println("Корневой элемент - " + p1.getRoot());
//            System.out.println("Родительская директория - " + p1.getParent());
//            System.out.println("Время создания - " + fileAtr.creationTime());
//            System.out.println("Время последнего изменения - " + Files.getLastModifiedTime(p1));
//            System.out.println("Время последнего открытия - " + fileAtr.lastAccessTime());
//            System.out.println("Размер в байтах - " + fileAtr.size());
//            System.out.println("Доступен для чтения - " + Files.isReadable(p1));
//            System.out.println("Доступен для записи - " + Files.isWritable(p1));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Path p2 = Paths.get("C:\\Users\\Rus\\IdeaProjects\\HomeWorkJava");
//        try {
//            Files.walkFileTree(p2, new MyVisitor());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> strings = new ArrayList<>();

        try {

            String file = reader.readLine();

            Path filePath = Paths.get(file);

            if (Files.exists(filePath)) {

                strings = Files.readAllLines(filePath);

                String [] copyStrings = new String[strings.size()];

                for (String s : strings) {
                    if (s.length() > 30) {

                    }
                }
                String copyfile = reader.readLine();
                Path copyPath = Paths.get(copyfile);
                Files.copy(filePath, copyPath,StandardCopyOption.ATOMIC_MOVE);


//                file = reader.readLine();
//                filePath = Paths.get(file);
//
//                if (Files.exists(filePath)) {
//
//                    while (Files.exists(filePath)){
//
//                        String [] strings1 = file.split("\\(+\\d+\\)");
//                        strings1[0] = strings1[0] + "(" + count + ").";
//                        StringBuilder builder = new StringBuilder();
//                        for(String s : strings1) {
//                            builder.append(s);
//                        }
//                        file = builder.toString();
//                        filePath = Paths.get(file);
//                        count++;
//                    }
//
//                    Files.write(filePath, copyStrings, StandardOpenOption.CREATE_NEW);
//                    count++;
//
//                } else {
//                    Files.write(filePath, copyStrings, StandardOpenOption.CREATE_NEW);
//                }
            }else {
                System.out.println("Файла не существует");
            }
            } catch(IOException e){
                e.printStackTrace();
            }

        }

}


