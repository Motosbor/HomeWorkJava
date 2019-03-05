package Collections.Airport;


import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Airport {

    TreeMap<Integer, LinkedList<Passenger>> airportMap ;

    public Airport(TreeMap<Integer, LinkedList<Passenger>> airportMap) {
        this.airportMap = airportMap;
    }

    public  void mapPut(LinkedList<Passenger> passengersList){

        for (Passenger p :passengersList) {
            if( this.airportMap.containsKey(p.getFlight())) {
                this.airportMap.get(p.getFlight()).add(p);
            }else {
                LinkedList<Passenger> list = new LinkedList<>();
                list.add(p);
                this.airportMap.put(p.getFlight(),list);
            }
        }
    }

    public TreeMap<Integer, LinkedList<Passenger>> getAirportMap() {
        return airportMap;
    }

    public void setAirportMap(TreeMap<Integer, LinkedList<Passenger>> airportMap) {
        this.airportMap = airportMap;
    }
}
