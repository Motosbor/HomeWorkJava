package XML.JAXB;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;

public class Group {

    private int groupNumber;
    private ArrayList<Student> students;

    @XmlAttribute
    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    @XmlElement(name = "Student")
    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Group() {
    }

    public Group(int gropuNumber, ArrayList<Student> students) {
        this.groupNumber = gropuNumber;
        this.students = students;
    }

    @Override
    public String toString() {
        String str = "Group № " + Integer.toString(groupNumber) + "\n";
        for (Student std: students) {
            str = str + std.toString() + "\n";
        }

        return str;
    }
}
