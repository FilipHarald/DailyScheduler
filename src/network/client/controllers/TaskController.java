/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.client.controllers;


import database.DatabaseController;
import entities.Task;
import entities.Task.SubTask;

import java.util.Date;
import java.util.LinkedList;

import miscellaneous.Updater;
import network.client.GUI.panels.TaskPanel;

/**
 *
 * @author Aya
 */
public class TaskController {

    private Task task;
    private DatabaseController database;
    private TaskPanel taskPanel;
    private Updater up;

    public TaskController(Task task) {
        this.task = task;
    }

    /**
     * creates a new task and saves it to the database 
     * @param authorId the id of the user who authored the task
     * @param description a description of what the task is about
     * @param subTasks the subtasks that belong to the task
     * @param date the date for the deadline for the task
     * @param Id the id for the given task
     */
    public void createTask(int authorId, String description, String[] subTasks, Date date, int Id) {
        Task tmpTask = new Task(authorId, description, subTasks, date, Id);
        tmpTask.getAuthor();
        tmpTask.getDescription();
        tmpTask.getSubtasks();
        tmpTask.getDate();
        tmpTask.getId();
        
        up.addTask(tmpTask);
    }
    
    //forward incoming task from client to GUI
    public void displayTask(Task task){
		//TODO: call method from GUI that displays the task in the GUI (must create method in taskPanel)
    	taskPanel.displayTask(task);
    	
    }
    
    public Task displayTaskList (Task task){
    	up.getTasks();
    	return task;
    }
    
    //check if task is complete, if it is then move it to completeTasks
    public void completedTask(LinkedList<SubTask> subTasks){
    	for(i = 0, subTasks.length, i++){
    		if(subTask.getCompletedBy() != null){
    			//TODO: move task from incompleteTask to completeTasks
    			
    		}
    		
    	}
    }
    

    /**
     * edits an existing task
     * @param authorId the id of the author user
     * @param description the description of the task to be edited
     * @param subTasks the subtask belonging to the given task
     * @param date the date for the day of editing
     * @param Id the id of the task 
     */
    public Task editTask() {
    	displayTask(task);
        //TODO: save updated info in database (create method in taskPanel)
    	task.getAuthor();
    	task.setDescription(taskPanel.getDescription());
    	task.addSubTask(null);
    	task.setDate(task.getDate());
    	task.getId();
     
    	return task;
    	
    }

    /**
     * deletes a Task from the database
     * @param taskIdDelete
     */
    public void deleteTask(Object obj) {
        database.deleteEntity(obj);
    }

    /**
     * add a new subtask to en existing task
     *
     * @param description
     */
    public void addSubTask(String description) {
       //TODO: create tmpSubTask
       task.addSubTask(description);
       //TODO: add to database
       //database.sendToTableTask(idtable_task, description, description);   
    }

    /**
     * deletes a SubTask from a Task
     * @param index
     */
    public void deleteSubTask(int index){
        task.removeSubTask(index);
        
    } 
    
    
}
