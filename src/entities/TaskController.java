/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import database.Database;
import java.util.Date;

/**
 *
 * @author Aya
 */
public class TaskController {

    private Task task;
    private Database database;

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
        //TODO: add to database       
    }
    /**
     * find an existing task in database by its id
     *
     * @param taskId
     * @return
     */
    public Task findTask(int taskId) {
        //find id for task in database
        return task;
    }

    /**
     * edits an existing task
     * @param authorId the id of the author user
     * @param description the description of the task to be edited
     * @param subTasks the subtask belonging to the given task
     * @param date the date for the day of editing
     * @param Id the id of the task 
     */
    public void editTask(int authorId, String description, String[] subTasks, Date date, int Id) {
        //TODO: save updated info in database
        editTask(authorId, description, subTasks, date, Id);
    }

    /**
     * deletes a Task from the database
     * @param taskIdDelete
     */
    public void deleteTask(int taskIdDelete) {
        database.deleteTask(taskIdDelete);
        //TODO: delete task from database
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
