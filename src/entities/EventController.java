/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.*;

/**
 *
 * @author Aya
 */
public class EventController {
    private Event event;
    //TODO: add frame
    
    
    public EventController(Event event){
        this.event = event;
        
    }
    
    //creates a new event 
    public void createEvent(String description, Date date, int Id){
        Event tmpEvent = new Event(description, date, Id);
        //TODO: add to database?
        
    }
    
    //finds an existing event by its Id
    public Event findEvent(int eventId){
        //TODO find Id in table in database
        return event;
    }
    
    //edits an existing event
    public void editEvent(String description, Date date, int Id){
        //TODO: save edited info in database
        editEvent(description, date, Id);
        
    }
    
    //delete an event by its Id
    public void deleteEvent(int eventIdRemove){
        //TODO: remove event from database 
        
    }
    
    
}
