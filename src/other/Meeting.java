package other;

import java.util.Date;

public class Meeting{
	
	private String description;
	private Date date;
	private long time;
	
	public Meeting (String description, Date date) {
		this.description = description;
		this.date = date;
		long time = date.getTime();
		
	}
	
	public String getDescription () {
		return description;
	}

	public Date getDate() {
		return date;
	}
	
	public long getTime (){
		return time;
	}
	

}
