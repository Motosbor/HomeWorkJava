package Collections.Letters;

import java.io.*;
import java.util.*;

public class Main {

//    private static void countCharacters(ArrayList<String> strings) {
//
//        final char[] chars = new char[26];
//        for (int i = 0; i < chars.length; i++) {
//            chars[i] = (char) (65 + i);
//        }
//        final int[] match = new int[256];
//        for (String s:strings) {
//            final char[] array = s.toCharArray();
//            for (final char c : array) {
//                match[c] = match[c] + 1;
//            }
//        }
//        int max = Integer.MIN_VALUE;
//        int position = 0;
//        for (int i = 0; i < chars.length; i++) {
//            if ( max < match[chars[i]]){
//                max = match[chars[i]];
//                position = i;
//            }
//            System.out.println("Символ '" + chars[i] + "' повторяется " + match[chars[i]] + " раз");
//        }
//        System.out.println("Наибольшее содержание символов - " + chars[position] + " В количестве - " + match[chars[position]]);
//    }


    public static void main(String[] args) {

        String s ;

        try (BufferedReader reader = new BufferedReader(new FileReader("Letter.txt"))) {

            ArrayList<String> stringArrayList = new ArrayList<>();
            Map<Character,Integer> charMap = new HashMap<Character, Integer>() ;
            while ((s = reader.readLine())!=null){
                int i =0;
                char[] chars = s.toCharArray();
                for (char c:chars) {
                   if(charMap.containsKey(c)){
                       charMap.put(c,(Integer)(charMap.get(c)+1));
                   }else {
                       charMap.put(c, (Integer) (1));
                   }
                }
                stringArrayList.add(s);
            }

            for (Map.Entry<Character,Integer> entry:charMap.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

            int max = Integer.MIN_VALUE;
            char c = 0;
            final char[] chars = new char[26];
            for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (65 + i);
            }

            for (char x : chars) {
                for (Map.Entry<Character,Integer> entry:charMap.entrySet()) {
                    if(entry.getKey().equals(x)){
                        if(entry.getValue()>max){
                            max = entry.getValue();
                            c = entry.getKey();
                        }
                    }
                }
            }

            System.out.println("Символ - " + c + " встречается чаще всего раз - " + max);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
