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
	private Date date;
	private LinkedList<String> participants;
	private int Id;

	public Event(String description, Date date, LinkedList<String> participants, int Id) {
		this.description = description;
		this.date = date;
		this.participants = participants;
		this.Id = Id;
	}

	/**
	 * @return the ID of the event
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @return the description of the event
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description that the event should change to
	 */
	public synchronized void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the date of the event
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date that the event should change to
	 */
	public synchronized void setDate(Date date) {
		this.date = date;
	}
        
        //gets the participants from the list
	public LinkedList<String> getParticipants(LinkedList<String> participants) {
		return participants;

	}

        //adds participants to the list
	public void setParticipants(LinkedList<String> participants) {
		this.participants = participants;
	}
	
	public String toString(){
		return description;
	}

}
