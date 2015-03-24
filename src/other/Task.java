package other;

import user.User;

public class Task {

	private User [] assignees;
	private String description;
	private User author;
	private Meeting date;
	
	public Task (User [] assignes, User author, Meeting date, String description) {
		this.assignees = assignes;
		this.author = author;
		this.date = date;
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
	
	public Meeting getDate() {
		return date;
	}
	
	
}
