package other;

import java.util.Calendar;
import user.User;

public class Task {

	private User [] assignees;
	private String description;
	private User author;
	private Calendar calendar;
	
	public Task (User [] assignes, User author, Calendar calendar, String description) {
		this.assignees = assignes;
		this.author = author;
		this.calendar = calendar;
		this.description = description;
	}
	
	public User [] getAssignes() {
		return assignees;
	}
	
	public String getDescription() {
		return description;
	}
	
	public User getManager() {
		return author;
	}
	
	public Calendar getCalender() {
		return calendar;
	}
	
	
}
