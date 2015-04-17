/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.client.controllers;

import database.DatabaseController;
import entities.Event;

import java.util.*;

import network.client.GUI.panels.CalendarPanel;

/**
 *
 * @author Aya
 */
public class EventController {

    private Event event;
    private DatabaseController database;
   	private CalendarPanel calendarPanel;

    public EventController(Event event) {
        this.event = event;

    }

    /**
     * creates a new event and adds it to the database
     * @param description a description of what the event is about
     * @param date the date of 
     * @param Id the id for the event
     */
    public void createEvent(String description, Date date, int eventId) {
        Event tmpEvent = new Event(description, date, eventId);
        database.SaveResult(tmpEvent);
        
        //TODO: add to database
      
    }
    //forward incoming event from client to GUI
    public void displayEvent(Event event){
		//TODO: call method from GUI that displays the event in the GUI
    	calendarPanel.displayEvent();
    	
    }
    
    /**
     * finds an existing event by its Id
     * @param eventId the id for the event
     * @return returns the event for the given id
     */
    public Event findEvent(int eventId) {
        //TODO find Id in table in database
    	try{
    		database.ShowResult(eventId);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        return event;
        displayEvent(event);
    }
    
    /**
     * edits an existing event and updates the info to the database
     * @param description the description for the event to be updated
     * @param date the date for the event
     * @param Id the id for the given event
     */
    public Event editEvent() {
    	displayEvent(event);
    	 //TODO: save updated info in database (create method in calendarPanel)
    	Event event = new Event(null, null, 0);
        event.setDescription(calendarPanel.getDescriptionText);
        event.setDate(calendarPanel.getDate);
        
        database.SaveResult();
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
