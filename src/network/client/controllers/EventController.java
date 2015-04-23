/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.client.controllers;

import database.DatabaseController;
import entities.Event;

import java.util.*;
import miscellaneous.Updater;

import network.client.GUI.panels.EventPanel;

/**
 *
 * @author Aya
 */
public class EventController {

    private Event event;
    private EventPanel calendarPanel;
    private ClientController cc;
    private Updater up;

    public EventController(Event event) {
        this.event = event;

    }

    /**
     * creates a new event and adds it to the database
     * @param description a description of what the event is about
     * @param date the date of 
     * @param Id the id for the event
     */
    public void createEvent(String description, Date date, LinkedList<String>participants, int Id) {
        Event event = new Event(description, date, participants, Id);
        participants = getParticipants();
        event.setDescription(calendarPanel.getDescription());
        event.setDate(calendarPanel.getDate()); 
        up.addEvent(event);
   
       
      
    }
    
    public void updateEventList(){
        up.addEvent(event);
        cc.updateGui(event, null, null);
    }
    
    //splits the String[] from the textarea to parts and saves them to a linkedlist
    private LinkedList<String> getParticipants() {
		String[] parts = calendarPanel.getParticipants().split(",");
		if (parts != null) {
			for (int i = 0; i < parts.length; i++) {
				parts[i] = parts[i].trim();
			}
			return new LinkedList<String>(Arrays.asList(parts));
		}
		return new LinkedList<String>();
	}
    
    //displays the list of events
    public Event displayEventList(Event event){
        up.getEvents();
        return event;
    }
    
    
    //forward incoming event from client to GUI
    public void displayEvent(Event event){
		//TODO: call method from GUI that displays the event in the GUI
    	calendarPanel.displayEvent(event);
    	
    }
    
    
    
    /**
     * edits an existing event and updates the info to the database
     * @param description the description for the event to be updated
     * @param date the date for the event
     * @param Id the id for the given event
     */
    public Event editEvent(String description, Date date, LinkedList<String>participants, int Id) {
    	displayEvent(event);
        
    	Event tmpEvent = new Event(description, date, participants, Id);
        participants = getParticipants();
        event.setDescription(calendarPanel.getDescription());
        event.setDate(calendarPanel.getDate()); 
        return tmpEvent;
    }

    /**
     * delete an event by its Id
     * @param eventIdDelete the id for the event to be deleted
     */
    public void deleteEvent(int eventIdDelete) {
        
        //TODO: remove event from database

    }

}
