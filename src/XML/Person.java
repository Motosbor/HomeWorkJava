package XML;

/**
 * Created by лоцманенко_рр on 13.03.2019.
 */
public class Person {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
