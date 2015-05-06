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
    private EventPanel eventPanel;
    private ClientController cc;
    private Updater up;

    public EventController(ClientController clientController) {
    	eventPanel = new EventPanel();
    	cc = clientController;
    }

    /**
     * creates a new event and adds it to the database
     * @param description a description of what the event is about
     * @param date the date of 
     * @param Id the id for the event
     */

    //create new event and send to cc
    public void createEvent(String description, Date date,LinkedList<String> participants, int eventId) {
        Event tmpEvent = new Event(description, date, participants, event.getId());
        cc.sendObject(tmpEvent);
    }
    
    //updates the eventlist (necessary?)
    public void updateEventList(){
        up.addEvent(event);
        cc.refresh();
    }
    
    //splits the String[] from the textarea to parts and saves them to a linkedlist
    public LinkedList<String> getParticipants() {
		String[] parts = eventPanel.getParticipants().split(",");
		if (parts != null) {
			for (int i = 0; i < parts.length; i++) {
				parts[i] = parts[i].trim();
			}
			return new LinkedList<String>(Arrays.asList(parts));
		}
		return new LinkedList<String>();
	}
    
    //displays the list of events
    public LinkedList<Event> displayEventList(LinkedList<Event> events){
        cc.update(up);
        return events;
    }
    
    
    //forward incoming event from client to GUI
    public void displayEvent(Event event){
		//TODO: call method from GUI that displays the event in the GUI
    	eventPanel.displayEvent(event);
    	
    }
    
    
    
    /**
     * edits an existing event and updates the info to the database
     * @param description the description for the event to be updated
     * @param date the date for the event
     * @param Id the id for the given event
     */
    public Event editEvent() {        
        event.setParticipants(getParticipants());
        event.setDescription(eventPanel.getDescription());
        event.setDate(eventPanel.getDate()); 
        
        up.addEvent(event);
        return event;
    }

    /**
     * delete an event by its Id
     * @param eventIdDelete the id for the event to be deleted
     */
    public void deleteEvent(int eventIdDelete) {
        
        //TODO: remove event from database

    }

	public void updatePanel(LinkedList<Event> events) {
		eventPanel.displayEventList(events);
	}
	public EventPanel getPanel(){
		return eventPanel;
	}
}
