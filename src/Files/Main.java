package Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {


    public static void main(String[] args){
        Path p1 = Paths.get("C:\\Users\\Rus\\IdeaProjects\\HomeWorkJava\\Letter.txt");


        try {

            BasicFileAttributes fileAtr = Files.readAttributes(p1, BasicFileAttributes.class);
            System.out.println("Имя файла - " + p1.getFileName());
            System.out.println("Корневой элемент - " + p1.getRoot());
            System.out.println("Родительская директория - " + p1.getParent());
            System.out.println("Время создания - " + fileAtr.creationTime());
            System.out.println("Время последнего изменения - " + Files.getLastModifiedTime(p1));
            System.out.println("Время последнего открытия - " + fileAtr.lastAccessTime());
            System.out.println("Размер в байтах - " + fileAtr.size());
            System.out.println("Доступен для чтения - " + Files.isReadable(p1));
            System.out.println("Доступен для записи - " + Files.isWritable(p1));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
