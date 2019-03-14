package XML;

import java.util.ArrayList;

/**
 * Created by лоцманенко_рр on 13.03.2019.
 */
public class House {
    private int id ;
    private ArrayList<Person> persons;

    public House(int id, ArrayList<Person> persons) {
        this.id = id;
        this.persons = persons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }
}
