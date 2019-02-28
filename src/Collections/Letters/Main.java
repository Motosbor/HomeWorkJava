package Collections.Letters;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String s;

        int num = 0;

        int letter = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("Letter.txt"))) {

            String numReg = "[0-9]";
            String letterReg = "[A-Z]";

            Pattern pattern = Pattern.compile(numReg);
            Pattern pattern1 = Pattern.compile(letterReg);

            while ((s = reader.readLine())!=null){

            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                num++;
            }

            Matcher matcher1 = pattern1.matcher(s);
            while (matcher1.find()){
                letter++;
            }

            }

            System.out.println(" Цифры - " + num + " Буквы - " + letter);
            if(num > letter) {
                System.out.println("Цифр больше");
            }else {
                System.out.println("Букв больше");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
