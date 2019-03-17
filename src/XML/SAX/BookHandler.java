package XML.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BookHandler extends DefaultHandler {

    private List<Book> books = new ArrayList<>();
    private Book book;
    private String open = "";


    public List<Book> getBooks(){
        return books;
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        open = qName;
        if(qName.equals("book")){
            book = new Book();
            String id = attributes.getValue("id");
            book.setId(id);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("book")){
            books.add(book);
            book = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String string = new String(ch,start,length);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(string.trim().equals("")) return;
        switch (open){
            case "author":book.setAuthor(string); break;
            case "title":book.setTitle(string); break;
            case "genre":book.setGenre(string);break;
            case "price":book.setPrice(Double.valueOf(string)); break;
            case "publish_date":
                try {
                    book.setPublishDate(dateFormat.parse(string));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "description":
                if(book.getDescription()!=null){
                book.setDescription(book.getDescription()+ string);break;
                } else{
                book.setDescription(string);
                }break;
        }
    }
}
