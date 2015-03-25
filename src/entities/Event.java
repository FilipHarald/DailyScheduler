package entities;

import java.util.Date;

public class Event{
	
	private String description;
	private Date date;
	
	public Event (String description, Date date) {
		this.description = description;
		this.date = date;
		
	}
	
	public String getDescription () {
		return description;
	}

	public Date getDate() {
		return date;
	}
	
	public long getTime (){
		time = date.getTime();
		return time;
	}
	

}
