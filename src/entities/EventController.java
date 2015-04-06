/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import database.Database;
import java.util.*;

/**
 *
 * @author Aya
 */
public class EventController {

    private Event event;
    private Database database;
    //TODO: add frame

    public EventController(Event event) {
        this.event = event;

    }

    /**
     * creates a new event and adds it to the database
     * @param description a description of what the event is about
     * @param date the date of 
     * @param Id the id for the event
     */
    public void createEvent(String description, Date date, int Id) {
        Event tmpEvent = new Event(description, date, Id);
        database.addEvent(tmpEvent);
        
        //TODO: add to database

    }
    
    /**
     * finds an existing event by its Id
     * @param eventId the id for the event
     * @return returns the event for the given id
     */
    public Event findEvent(int eventId) {
        
        //TODO find Id in table in database
        return event;
    }
    
    /**
     * edits an existing event and updates the info to the database
     * @param description the description for the event to be updated
     * @param date the date for the event
     * @param Id the id for the given event
     */
    public void editEvent(String description, Date date, int Id) {
        Id = event.getId();
        event.setDescription(description);
        event.setDate(date);
        
        //TODO: save edited info in database
    }

    /**
     * delete an event by its Id
     * @param eventIdDelete the id for the event to be deleted
     */
    public void deleteEvent(int eventIdDelete) {
        database.deleteEvent(eventIdDelete);
        //TODO: remove event from database

    }

}
