package XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.util.ArrayList;


/**
 * Created by лоцманенко_рр on 11.03.2019.
 * XML is XML ааа
 */
public class Main {


    private static Element createHouse(Document doc, House house){

        Element houseElement = doc.createElement("House");

        Element idElement = doc.createElement("id");

        houseElement.setAttribute("no",Integer.toString(house.getId()));

        Element pesronsElement = doc.createElement("Persons");

        for (Person per:house.getPersons()) {

            Element onePersonElement = doc.createElement("Person");

            Element personNameElement = doc.createElement("name");

            personNameElement.setTextContent(per.getName());

            Element personDescriptionElement = doc.createElement("Description");

            personDescriptionElement.setTextContent(per.getDescription());

            onePersonElement.appendChild(personNameElement);

            onePersonElement.appendChild(personDescriptionElement);
            pesronsElement.appendChild(onePersonElement);

        }

        houseElement.appendChild(pesronsElement);

        return houseElement;

    }


    public static void Transformer(Document doc){
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(doc);//что сохряняем
            StreamResult result = new StreamResult(new FileOutputStream("src/XML/Houses.xml"));//куда сохраняем
            transformer.transform(source, result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static Node findMostPopulate(Document doc){

        Element root = doc.getDocumentElement();
        Node mostPopulateHouse = null;

        NodeList rootList = root.getChildNodes();
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i <rootList.getLength() ; i++) {

            Node houses = rootList.item(i);
            NodeList housesInfo = houses.getChildNodes();


            for (int j = 0; j <housesInfo.getLength() ; j++) {
                Node persons = housesInfo.item(j);
                NodeList personsInfo = persons.getChildNodes();
                if(persons.getNodeName().startsWith("#")) continue;

                count = 0;

                for (int k = 0; k <personsInfo.getLength() ; k++) {
                    Node persona = personsInfo.item(k);
                    NodeList personaValue = persona.getChildNodes();
                    if(persona.getNodeName().equals("Person")){
                        count ++;
                    }
                }
                if(max <count){
                    max = count;
                    mostPopulateHouse = rootList.item(i);
                }
            }
        }

        return mostPopulateHouse;
    }


    public static void main(String[] args) throws ParserConfigurationException {



        House house = new House(4,new ArrayList<Person>());

        ArrayList<Person> persons = new ArrayList<>();

        persons.add(new Person("Igor","Lonely"));

        int maxPeople = 0;

        house.setPersons(persons);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("src/XML/Houses.xml");
            Element newHouse = createHouse(doc,house);
            doc.getDocumentElement().appendChild(newHouse);
            Transformer(doc);
            System.out.println("Most populated house is house - " + findMostPopulate(doc).getAttributes().getNamedItem("no"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(maxPeople);





    }

}
