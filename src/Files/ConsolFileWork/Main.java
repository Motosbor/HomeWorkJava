package Files.ConsolFileWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args){

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String source = reader.readLine();
            String path = reader.readLine();
            WorkWithFiles.copyFile(path,source);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
