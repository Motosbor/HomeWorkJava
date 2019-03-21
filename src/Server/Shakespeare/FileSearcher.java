package Server.Shakespeare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FileSearcher  {


    public List<String> sonet = new ArrayList<String>();


    public FileSearcher() {

        try (BufferedReader reader = new BufferedReader(new FileReader("text.txt"))) {

            Map<Integer,List<String>> map = new HashMap<>();
            List<String> tempList = new ArrayList<>();
            List<String> sonetList = new ArrayList<>();
            String s ;
            int count = 0;

            while ((s = reader.readLine())!=null){
                tempList.add(s);
            }

            for (String str:tempList) {
                if(str.equals("")){
                    map.put(count,new ArrayList<>(sonetList));
                    count++;
                    sonetList.clear();
                }
                sonetList.add(str);
            }
            this.sonet = map.get((0+(int)(Math.random()*count)));

        }catch (IOException e){
            e.printStackTrace();
        }

    }


    public List<String> getSonet() {
        return this.sonet;
    }
}
