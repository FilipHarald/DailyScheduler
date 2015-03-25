package entities;

import java.util.Date;

public class Meeting{
	
	private String description;
	private Date date;
	private long time;
	
	public Meeting (String description, Date date) {
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
