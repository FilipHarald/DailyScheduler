package entities;

import java.util.LinkedList;

public class Task {

	private User author;
	private String description;
	private LinkedList<SubTask> subTasks;
	private Event date;

	public Task(User author, String description, String[] subTasks, Event date) {
		this.author = author;
		this.description = description;
		
		LinkedList<SubTask> temp = new LinkedList<SubTask>();
		for(String str : subTasks){
			temp.add(new SubTask(str));
		}
		this.subTasks = temp;
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String[] getSubTasksDescriptions() {
		String[] temp = new String[subTasks.size()];
		int i = 0;
		for(SubTask st : subTasks){
			temp[i++] = st.getDescription();
		}
		return temp; 
	}
	
	public User[] getSubTasksCompletedBy() {
		User[] temp = new User[subTasks.size()];
		int i = 0;
		for(SubTask st : subTasks){
			temp[i++] = st.getCompletedBy();
		}
		return temp; 
	}

	public void addSubTasks(String description) {
		subTasks.add(new SubTask(description));
	}
	
	public boolean removeSubTask(String description){
		boolean temp = false;
		for(SubTask st : subTasks){
			if(st.getDescription().equals(description)){
				temp = subTasks.remove(st);
			}
		}
		return temp;
	}

	public Event getDate() {
		return date;
	}

	public void setDate(Event date) {
		this.date = date;
	}

	public User getAuthor() {
		return author;
	}
	
	private class SubTask{
		private User completedBy;
		private String description;

		public SubTask(String description) {
			this.description = description;
			this.completedBy = null;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public User getCompletedBy() {
			return completedBy;
		}

		public void setCompletedBy(User completedBy) {
			this.completedBy = completedBy;
		}

	}

}
