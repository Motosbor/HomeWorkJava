package Collections.Airport;


import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Airport {

    TreeMap<Integer, LinkedList<Passenger>> airportMap ;

    public Airport(TreeMap<Integer, LinkedList<Passenger>> airportMap) {
        this.airportMap = airportMap;
    }

    public  void mapPut(Integer x, Passenger p){
        LinkedList<Passenger> list = new LinkedList<>();
        list.add(p);
        this.airportMap.put(x,list);

    }

    public TreeMap<Integer, LinkedList<Passenger>> getAirportMap() {
        return airportMap;
    }

    public void setAirportMap(TreeMap<Integer, LinkedList<Passenger>> airportMap) {
        this.airportMap = airportMap;
    }
}
