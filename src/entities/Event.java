package entities;

import java.util.Date;

/**
 * This class represents an event with a certain (start) date and time and description.
 * 
 * @author Filip
 *
 */
public class Event{
	
	private String description;
	private Date date;
	private int Id;
	
	public Event (String description, Date date, int Id) {
		this.description = description;
		this.date = date;
		this.Id = Id;
	}

	/**
	 * @return the ID of the event
	 */
	public int getId () {
		return Id;
	}
	
	/**
	 * @return the description of the event
	 */
	public String getDescription () {
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
	public void setDate(Date date) {
		this.date = date;
	}

}
