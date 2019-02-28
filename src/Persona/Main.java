package Persona;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Persona children = new Persona("Ivan", "Ivanov", "Ivanovich");

        Persona children1 = new Persona("Maria", "Ivanova", "Ivanovna");

        Persona children2 = new Persona("Boris", "Ivanov", "Ivanovich");

        Persona persona = new Persona("Ivan", "Ivanov", "Mihailovich");

        persona.setChildrens( new Persona[]{children, children1, children2});

//        Persona.personaPrinter(persona);
//
//        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("Persona.dat"))) {
//
//            stream.writeObject(persona);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream("Persona.dat"))){
            Persona persona1 = (Persona) stream.readObject();
            Persona.personaPrinter(persona1);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }


    }
}

