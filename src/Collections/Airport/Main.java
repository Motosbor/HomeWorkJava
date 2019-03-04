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

    public static void main(String[] args){


//        while (true){
//            BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
//           try {
//               if(reader.readLine().contains("0")){
//                   break;
//               }
//               ArrayList<Passenger> flightList = new ArrayList<>();
//               System.out.println("Введите номер рейса :");
//               int flightNum = Integer.parseInt(reader.readLine());
//
//               while (true){
//                   if(reader.readLine().contains("stop")){
//                       break;
//                   }
//                   System.out.println("Внесите данные пассажира для рейса - № " + flightNum);
//                   String name = reader.readLine();
//                   int doc = Integer.parseInt(reader.readLine());
//                   flightList.add(new Passenger(name,doc,flightNum));
//               }
//               airport.put(flightNum,flightList);
//           }catch (IOException e){
//               e.printStackTrace();
//           }
//        }


//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        Flight flight = new Flight(1,new ArrayList<Passenger>());
//        Flight flight1 = new Flight(2,new ArrayList<Passenger>());
//        Flight flight2 = new Flight(3,new ArrayList<Passenger>());
//        Flight flight3 = new Flight(4,new ArrayList<Passenger>());
//
//        ArrayList<Flight> flights = new ArrayList<>();
//
//
//        while (true){
//            try {
//                System.out.println("'0' для остановки ввода пассажиров");
//                if(reader.readLine().contains("0")){
//                    break;
//                }
//                System.out.println("Введите имя пассажира:");
//                String name = reader.readLine();
//                System.out.println("Введите документы:");
//                int docNum = Integer.parseInt(reader.readLine());
//                System.out.println("Введите рейс пассажира:");
//                int flightNum = Integer.parseInt(reader.readLine());
//                switch (flightNum){
//                    case 1:flight.getFlightList().add(new Passenger(name,docNum,flightNum));break;
//                    case 2:flight1.getFlightList().add(new Passenger(name,docNum,flightNum));break;
//                    case 3:flight2.getFlightList().add(new Passenger(name,docNum,flightNum));break;
//                    case 4:flight3.getFlightList().add(new Passenger(name,docNum,flightNum));break;
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        flights.add(flight3);
//        flights.add(flight1);
//        flights.add(flight2);
//        flights.add(flight);
//
//        for (Flight f:flights) {
//            Collections.sort(f.getFlightList(), new FlightsCompare());
//           airport.put(f.getFlightNum(),f);
//        }
//
//        for(Map.Entry<Integer, Flight> item : airport.entrySet()){
//            System.out.println(item.getKey());
//            passengerList(item.getValue());
//        }

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

        for (Passenger p :passengersList) {
           if(airport1.getAirportMap().containsKey(p.getFlight())) {
                airport1.getAirportMap().get(p.getFlight()).add(p);
            }else {
               airport1.mapPut(p.getFlight(),p);
           }
        }

        for(Map.Entry<Integer,LinkedList<Passenger>> item : airport1.getAirportMap().entrySet()){
            System.out.println(item.getKey());
            Collections.sort(item.getValue(), new FlightsCompare());
            passengerList(item.getValue());
        }

    }
}
