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
    	eventPanel = new EventPanel(this);
    	cc = clientController;
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
//        event.setParticipants(getParticipants());
        event.setDescription(eventPanel.getDescription());
        event.setDate(eventPanel.getDate()); 
        
        up.addEvent(event);
        return event;
    }
    
    public void sendEvent(String description, Date date) {
//        Event tmpEvent = new Event(description, date, participants, event.getId());
        cc.sendObject(new Event(description, cc.getUserId(), date, 0));
        System.out.println("3" + cc);
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
