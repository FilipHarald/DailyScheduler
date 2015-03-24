package other;

import user.User;

public class Task {

	private SubTask [] subTasks;
	private String description;
	private User author;
	private Meeting date;
	
	public Task (SubTask [] assignes, User author, Meeting date, String description) {
		this.subTasks = assignes;
		this.author = author;
		this.date = date;
		this.description = description;
	}
	
	public SubTask [] getAssignes() {
		return subTasks;
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
