package XML.SAX;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        BookHandler handler = new BookHandler();
        parser.parse(new File("books.xml"),handler);

        List<Book> bookList = handler.getBooks();

        for (Book book:bookList) {
            System.out.println(book.toString());
        }

    }
}
