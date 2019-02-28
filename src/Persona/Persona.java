package Persona;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Persona implements Serializable {

    private String name;
    public String name2;
    private String lasName;
    private String fatherName;
    private ArrayList<Persona> childrens;
    public static final long serialVersionUID = 1;

    public Persona(String name, String lasName, String fatherName) {
        this.name = name;
        this.lasName = lasName;
        this.fatherName = fatherName;
    }

    public static void personaPrinter(Persona p){
        System.out.println("Name -" + p.getName() + " Lastname-" + p.getLasName() + " FatherName-" + p.getFatherName() + " " + p.name2);
        for (Persona persona: p.getChildrens()) {
            System.out.println("Children - " + persona.getName());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLasName() {
        return lasName;
    }

    public void setLasName(String lasName) {
        this.lasName = lasName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public ArrayList<Persona> getChildrens() {
        return childrens;
    }

    public void setChildrens(ArrayList<Persona> childrens,Persona[] personas) {
        ArrayList<Persona> personaArr = new ArrayList<Persona>(Arrays.asList(personas));
        this.childrens = personaArr;
    }
}
