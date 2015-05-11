package entities;

import java.io.Serializable;
import java.util.*;

/**
 * This class represents an event with a certain (start) date and time and
 * description.
 *
 * @author Filip
 *
 */
public class Event implements Serializable {

    private String description;
    private int authorID;
    private Date date;
    private int Id;
    static final long serialVersionUID = 4141671890272788617L;

    public Event(String description, int authorID, Date date, int Id) {
        this.description = description;
        this.authorID = authorID;
        this.date = date;
        this.Id = Id;
    }

    /**
     * @return the ID of the event
     */
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public int getAuthorID(){
        return authorID;
    }
    
    public void setAuthorID(){
        this.authorID = authorID;
    }

    /**
     * @return the description of the event
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description that the event should change to
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the date of the event
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date that the event should change to
     */
    public synchronized void setDate(Date date) {
        this.date = date;
    }

    public String toString() {
        return description;
    }

}
