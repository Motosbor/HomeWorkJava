package XML.JAXB;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = "name")
public class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
