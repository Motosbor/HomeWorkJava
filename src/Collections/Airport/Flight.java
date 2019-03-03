package Collections.Airport;

import java.util.ArrayList;

public class Flight {

    private int flightNum;
    private ArrayList<Passenger> flightList;

    public Flight(int flightNum, ArrayList<Passenger> flightList) {
        this.flightNum = flightNum;
        this.flightList = flightList;
    }

    public int getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(int flightNum) {
        this.flightNum = flightNum;
    }

    public ArrayList<Passenger> getFlightList() {
        return flightList;
    }

    public void setFlightList(ArrayList<Passenger> flightList) {
        this.flightList = flightList;
    }
}
