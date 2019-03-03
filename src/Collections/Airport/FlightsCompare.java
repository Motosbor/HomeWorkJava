package Collections.Airport;

import java.util.Comparator;

public class FlightsCompare implements Comparator<Passenger> {
    @Override
    public int compare(Passenger o1, Passenger o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
