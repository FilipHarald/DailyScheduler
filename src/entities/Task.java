package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;

/**
 * This class represents a task-list that when each list-item (sub task) is set
 * to completed it keeps track of which user has completed which task.
 * 
 * @author Filip
 *
 */
public class Task implements Serializable {

	private int authorId;
	private int teamId;
	private String description;
	private LinkedList<SubTask> subTasks;
	private Date date;
	private int Id;


	public Task(int authorId, String description, String[] subTasks, Date date, int Id) {
		this.authorId = authorId;
		this.description = description;
		
		LinkedList<SubTask> temp = new LinkedList<SubTask>();
		if(subTasks != null){
			for (String str : subTasks) {
				temp.add(new SubTask(str));
			}			
		}
		this.subTasks = temp;
		this.date = date;
		this.Id = Id;
	}
	
	public void setAuthorId (int authorId){
		this.authorId = authorId;
	}
	
	public int getId() {
		return Id;
	}
	
	public void setId (int Id){
		this.Id = Id; 
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
	public void completeSubTask(int index, int userId){
		subTasks.get(index).setCompletedBy(userId);
	}
	
	/**
	 * @param index the index of the subtask
	 */
	public void unCompleteSubTask(int index){
		subTasks.get(index).setCompletedBy(0);
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
	
	public boolean isComplete(){
		boolean taskIsComplete = true;
		for(SubTask st : subTasks){
			if(st.getCompletedBy() == 0){
				taskIsComplete = false;
			}
		}
		return taskIsComplete;
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
	public int getAuthor() {
		return authorId;
	}
	
	

	/**
	 * This class represents the sub tasks of a task.
	 * @author Filip
	 *
	 */
	private class SubTask implements Serializable {

		private int completedByUserId;
		private String description;

		public SubTask(String description) {
			this.description = description;
			this.completedByUserId = 0;
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
		public int getCompletedBy() {
			return completedByUserId;
		}

		/**
		 * @param completedByUserId the ID of the user which has completed the task
		 */
		public void setCompletedBy(int completedByUserId) {
			this.completedByUserId = completedByUserId;
		}

		@Override
		public String toString() {
			return description + ",|," + completedByUserId;
		}
	}


	public void setSubtasks(String[] subtasks) {
		
		
	}

	public int getTeamId() {
		return teamId;
	}
	
	public String toString (){
		return description;
		
	}

}
