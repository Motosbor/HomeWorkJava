package Files;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
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

                ArrayList<String> copyStrings = new ArrayList<>();

                for (String s : strings) {
                    if (s.length() > 30) {
                        copyStrings.add(s);
                    }
                }

                String copyfile = reader.readLine();
                String keep = copyfile;
                String plus = ".txt";
                Path copyPath = Paths.get(copyfile + plus);

                if (Files.exists(copyPath)) {
                    int count = 1;
                    while (Files.exists(copyPath)){
                        copyfile = copyfile + count;
                        copyPath = Paths.get(copyfile + plus);
                        copyfile = keep;
                        count++;
                    }
                    Files.write(copyPath, copyStrings,StandardOpenOption.CREATE_NEW);
                }else {
                    Files.write(copyPath, copyStrings,StandardOpenOption.CREATE_NEW);
                }

            }else {
                System.out.println("Файла не существует");
            }
            } catch(IOException e){
                e.printStackTrace();
            }

        }

}


