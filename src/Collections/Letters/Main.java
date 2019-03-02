package Collections.Letters;

import java.io.*;
import java.util.ArrayList;

public class Main {

    private static void countCharacters(ArrayList<String> strings) {

        final char[] chars = new char[26];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (65 + i);
        }
        final int[] match = new int[256];
        for (String s:strings) {
            final char[] array = s.toCharArray();
            for (final char c : array) {
                match[c] = match[c] + 1;
            }
        }
        int max = Integer.MIN_VALUE;
        int position = 0;
        for (int i = 0; i < chars.length; i++) {
            if ( max < match[chars[i]]){
                max = match[chars[i]];
                position = i;
            }
            System.out.println("Символ '" + chars[i] + "' повторяется " + match[chars[i]] + " раз");
        }
        System.out.println("Наибольшее содержание символов - " + chars[position] + " В количестве - " + match[chars[position]]);
    }


    public static void main(String[] args) {
        String s ;


        try (BufferedReader reader = new BufferedReader(new FileReader("Letter.txt"))) {

            ArrayList<String> stringArrayList = new ArrayList<>();

            while ((s = reader.readLine())!=null){
                stringArrayList.add(s);
            }

            countCharacters(stringArrayList);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
