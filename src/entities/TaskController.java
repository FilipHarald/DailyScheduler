/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author Aya
 */
public class TaskController {
    private Task task;
    
    
    public TaskController(Task task){
        this.task = task;
    }
    
    public void createTask(User author, String description, String[] subTasks, Date date, int Id){
        Task tmpTask = new Task(author, description, subTasks, date, Id);
        //TODO: add to database       
    }
    
    //find an existing task in database by its id
    public Task findTask(int taskId){
        //find id for task in database
        return task;
    }
    
    //edit an existing task
    public void editTask(User author, String description, String[] subTasks, Date date, int Id){
        //TODO: save updated info in database
        editTask(author, description, subTasks, date, Id);
    }
    
    public void deleteTask(int taskIdRemove){
        //TODO: delete task from database
    }
    
    //add a new subtask to en existing task
    public void addSubTask(String description){
        
        
    }
    
    
    
    
    
    
}
