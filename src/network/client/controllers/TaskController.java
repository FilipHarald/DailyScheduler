/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.client.controllers;

import entities.Task;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import network.client.GUI.panels.TaskPanel;

/**
 *
 * @author Aya & Henrik
 */
public class TaskController {

	private ClientController cc;
	private Task task;
	private TaskPanel taskPanel;

	public TaskController(ClientController clientController) {
		taskPanel = new TaskPanel(this);
		cc = clientController;
	}

	/**
	 * creates a new task and saves it to the database
	 * 
	 * @param authorId
	 *            the id of the user who authored the task
	 * @param description
	 *            a description of what the task is about
	 * @param subTasks
	 *            the subtasks that belong to the task
	 * @param date
	 *            the date for the deadline for the task
	 * @param Id
	 *            the id for the given task
	 */
//	public Task createTask() {
//
//		task.setAuthorId(task.getAuthor());
//		task.setDescription(task.getDescription());
//		task.setSubtasks(task.getSubtasks());
//		task.getDate();
//		task.setId(task.getId());
//
//		return task;
//	}

	// forward incoming task from client to GUI
	public void displayTask(Task task) {
		// TODO: call method from GUI that displays the task in the GUI (must
		// create method in taskPanel)
		taskPanel.displayTask(task);

	}


	public void sendTask(String description, String[] subTasks, Date date) {
		Task temptask = new Task(cc.getUserId(), description, getSubTasks(), date, 0);
		cc.sendObject(temptask);
	}

	public void sendEditTask(String description, String[] subTasks, Date date) {
		Task task = new Task(0, description, subTasks, date, 0);
		cc.sendObject(task);
	}

	private String[] getSubTasks() {
		
		String[] tasks = taskPanel.getDescriptionSubTask().split("/n");
		int [] toBeReturned = new int [tasks.length];
		int i = 0;
		if (tasks != null) {
			for (String s : tasks) {
				System.out.println(tasks);
				toBeReturned[i++] = Integer.parseInt(s.toString());
			}
			
		}
		return tasks;
		
	}

	/**
	 * edits an existing task
	 * 
	 * @param authorId
	 *            the id of the author user
	 * @param description
	 *            the description of the task to be edited
	 * @param subTasks
	 *            the subtask belonging to the given task
	 * @param date
	 *            the date for the day of editing
	 * @param Id
	 *            the id of the task
	 */
	public Task editTask() {
		displayTask(task);
		// TODO: save updated info in database (create method in taskPanel)
		task.getAuthor();
		task.setDescription(taskPanel.getDescriptionSubTask());
		task.addSubTask(null);
		task.setDate(task.getDate());
		task.getId();

		return task;

	}

	/**
	 * deletes a Task from the database
	 * 
	 * @param taskIdDelete
	 * @throws SQLException
	 */
	public void deleteTask(Object obj) {
		cc.sendObjectToDelete(obj);
	}

	/**
	 * add a new subtask to en existing task
	 *
	 * @param description
	 * @return
	 */
	public String addSubTask(String description) {
		// TODO: create tmpSubTask
		getSubTasks();
//		task.addSubTask(taskPanel.getDescriptionSubTask());
		// TODO: add to database
		// database.sendToTableTask(idtable_task, description, description);
		return description;
	}

	public int getId() {
		return task.getAuthor();
	}

	public Date getDate() {
		return task.getDate();
	}

	/**
	 * deletes a SubTask from a Task
	 * 
	 * @param index
	 */
	public void deleteSubTask(int index) {
		task.removeSubTask(index);

	}

	public void updatePanel(LinkedList<Task> tasks) {
		LinkedList<Task> completeTasks = new LinkedList();
		LinkedList<Task> inCompleteTasks = new LinkedList();
		for (Task t : tasks) {
			if (t.isComplete() == true) {
				completeTasks.add(t);
			} else if (t.isComplete() == false) {
				inCompleteTasks.add(t);
			}
		}
		taskPanel.taskListDisplayCompleted(completeTasks);
		taskPanel.taskListDisplayIncompleted(inCompleteTasks);
	}

	public TaskPanel getPanel() {
		return taskPanel;
	}

	public String getDescription() {
		return task.getDescription();
	}

	public String getTitle() {
		return task.getTitle();
	}

}
