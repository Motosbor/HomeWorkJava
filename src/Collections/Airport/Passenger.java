package Collections.Airport;

public class Passenger {
    private String name;
    private int docNum;
    private int flight;

    public Passenger(String name, int docNum, int flight) {
        this.name = name;
        this.docNum = docNum;
        this.flight = flight;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDocNum() {
        return docNum;
    }

    public void setDocNum(int docNum) {
        this.docNum = docNum;
    }

    public int getFlight() {
        return flight;
    }

    public void setFlight(int flight) {
        this.flight = flight;
    }
}
