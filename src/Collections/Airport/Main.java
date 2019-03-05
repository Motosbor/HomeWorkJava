package Collections.Airport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.util.*;


public class Main {

    public static  void passengerList(LinkedList<Passenger> linkedList){
        if(linkedList.isEmpty()){
            System.out.println("Рейс пуст");
        }else {
            int sum = 0;
            for (Passenger p : linkedList) {
                System.out.println(p.getName() + " " + p.getDocNum());
                sum++;
            }
            System.out.println("Количество пассажиров - " + sum);
        }
    }

    public static void printMap(Airport airport){

        for(Map.Entry<Integer,LinkedList<Passenger>> item : airport.getAirportMap().entrySet()){
            System.out.println(item.getKey());
            Collections.sort(item.getValue(), new FlightsCompare());
            passengerList(item.getValue());

        }
    }

    public static void main(String[] args){



        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Passenger> passengersList = new LinkedList<>();


        while (true){

            try {

                System.out.println("'0' для остановки ввода пассажиров");
                if(reader.readLine().contains("0")){
                    break;
                }
                System.out.println("Введите имя пассажира:");
                String name = reader.readLine();
                System.out.println("Введите документы:");
                int docNum = Integer.parseInt(reader.readLine());
                System.out.println("Введите рейс пассажира:");
                int flightNum = Integer.parseInt(reader.readLine());
                passengersList.add(new Passenger(name,docNum,flightNum));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Airport airport1 = new Airport(new TreeMap<Integer,LinkedList<Passenger>>());

        airport1.mapPut(passengersList);

        printMap(airport1);

    }
}
