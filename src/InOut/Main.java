package InOut;

import java.io.*;
import java.util.LinkedList;


public class Main {

    public static void main(String[] args) {

        String s;
        LinkedList<String> linkedList = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("text"))) {

            while ((s = reader.readLine()) != null) {
                if(s.matches(".*([1-9][0-9])|.*[7-9]")) {
                    String temp = s.toUpperCase();
                    linkedList.add(temp);
                }else {
                    linkedList.add(s);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter out = new PrintWriter(new FileWriter("text.txt"))) {

            for (String string: linkedList) {

                out.println(string);

                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String string:linkedList) {
            System.out.println(string);
        }
    }
}
