package XML.JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws JAXBException {

        Student student = new Student("Vasil");
        Student student1 = new Student("Ivan");
        Group group = new Group(1,new ArrayList<Student>());
        group.getStudents().add(student);
        group.getStudents().add(student1);
        Student student2 = new Student("Matia");
        Student student3 = new Student("Mihail");
        Group group1 = new Group(2,new ArrayList<Student>());
        group1.getStudents().add(student2);
        group1.getStudents().add(student3);

        Allgroups allgroups = new Allgroups(new ArrayList<Group>());
        allgroups.getAllGroups().add(group);
        allgroups.getAllGroups().add(group1);

        JAXBContext jaxbContext = JAXBContext.newInstance(Allgroups.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(allgroups, new File("Groups.xml"));

        JAXBContext context = JAXBContext.newInstance(Allgroups.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Allgroups allgroups1 = (Allgroups)unmarshaller.unmarshal(new File("Groups.xml"));

        for (Group gr: allgroups1.getAllGroups()) {
            System.out.println(gr.toString());
        }

    }
}
