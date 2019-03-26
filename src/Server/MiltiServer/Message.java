package Server.MiltiServer;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {


    private Date date;
    private String message;

    public Message(String message) {
        this.date = new Date();
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {

        String mess = "{" + this.date + "}" + this.message;

        return mess;

    }
}
