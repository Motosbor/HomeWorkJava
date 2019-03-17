package XML.JAXB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
@XmlRootElement
public class Allgroups {

    ArrayList<Group> allGroups;

    @XmlElement(name = "group")
    public ArrayList<Group> getAllGroups() {
        return allGroups;
    }

    public void setAllGroups(ArrayList<Group> allGroups) {
        this.allGroups = allGroups;
    }

    public Allgroups(ArrayList<Group> allGroups) {
        this.allGroups = allGroups;
    }

    public Allgroups() {
    }
}
