package entities;

import java.util.Date;
import java.util.LinkedList;

/**
 * This class represents a task-list that when each list-item (sub task) is set
 * to completed it keeps track of which user has completed which task.
 * 
 * @author Filip
 *
 */
public class Task {

	private User author;
	private String description;
	private LinkedList<SubTask> subTasks;
	private Date date;

	public Task(User author, String description, String[] subTasks, Date date) {
		this.author = author;
		this.description = description;

		LinkedList<SubTask> temp = new LinkedList<SubTask>();
		for (String str : subTasks) {
			temp.add(new SubTask(str));
		}
		this.subTasks = temp;
		this.date = date;
	}

	/**
	 * @return the description of the task
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description that the task should change to
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Adds a new sub task with the desired description.
	 * @param description the description of the new sub task
	 */
	public void addSubTask(String description) {
		subTasks.add(new SubTask(description));
	}

	/**
	 * Removes a sub task with the specified index.
	 * @param index the index of the sub task
	 */
	public void removeSubTask(int index) {
		subTasks.remove(index);
	}
	
	/**
	 * @param index the index of the sub task
	 * @param userId the user ID which has completed the sub task
	 */
	public void completeSubTask(int index, String userId){
		subTasks.get(index).setCompletedBy(userId);
	}
	
	/**
	 * @param index the index of the subtask
	 */
	public void unCompleteSubTask(int index){
		subTasks.get(index).setCompletedBy(null);
	}
	
	/**
	 * @param index the index of the sub task
	 * @param description the new description of the sub task
	 */
	public void setSubTaskDescription(int index, String description){
		subTasks.get(index).setDescription(description);
	}
	
	/**
	 * Returns a list of string representations of all the task objects sub tasks.
	 * @return a list of string representation of the sub tasks
	 */
	public String[] getSubtasks() {
		String[] temp = new String[subTasks.size()];
		int i = 0;
		for (SubTask st : subTasks) {
			temp[i++] = st.toString();
		}
		return temp;
	} 

	/**
	 * @return the date of the task
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date that the task will change to
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the author of the task
	 */
	public User getAuthor() {
		return author;
	}

	/**
	 * This class represents the sub tasks of a task.
	 * @author Filip
	 *
	 */
	private class SubTask {

		private String completedByUserId;
		private String description;

		public SubTask(String description) {
			this.description = description;
			this.completedByUserId = null;
		}

		/**
		 * @return the description of the sub task
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @param description the description that the task will change to
		 */
		public void setDescription(String description) {
			this.description = description;
		}

		/**
		 * @return the ID of the user which has completed the sub task
		 */
		public String getCompletedBy() {
			return completedByUserId;
		}

		/**
		 * @param completedByUserId the ID of the user which has completed the task
		 */
		public void setCompletedBy(String completedByUserId) {
			this.completedByUserId = completedByUserId;
		}

		@Override
		public String toString() {
			return description + ",|," + completedByUserId;
		}
	}
}
