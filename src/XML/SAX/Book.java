package XML.SAX;

import java.util.Date;

public class Book {
    private String id;
    private String author;
    private String title;
    private String genre;
    private double price;
    private Date publishDate;
    private String description;

    public Book() {
    }

    public Book(String id, String title, String genre, double price, Date publishDate, String description) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.publishDate = publishDate;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        String value = "Book : " + "\n" + "id-"+ id + "\n"
        + "author-" + author + "\n" + "title" + title + "\n"
        + "genre-" + genre + "\n" + "price-" + price +"\n"
        + "date-" + publishDate + "\n" + "decription-" + description;
        return value;
    }
}
