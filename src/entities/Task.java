package entities;


public class Task {

	private SubTask[] subTasks;
	private String description;
	private User author;
	private Event date;

	public Task(SubTask[] assignes, User author, Event date, String description) {
		this.subTasks = assignes;
		this.author = author;
		this.date = date;
		this.description = description;
	}

	public SubTask[] getAssignes() {
		return subTasks;
	}

	public String getDescription() {
		return description;
	}

	public User getManager() {
		return author;
	}

	public Event getDate() {
		return date;
	}

	private class SubTask {
		private User completedBy;
		private String description;

		public User getCompletedBy() {
			return completedBy;
		}

		public void setCompletedBy(User completedBy) {
			this.completedBy = completedBy;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

	}

}
