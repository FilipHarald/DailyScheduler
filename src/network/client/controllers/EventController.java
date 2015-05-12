package network.client.controllers;

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

    /**
     *
     * @param clientController
     */
    public EventController(ClientController clientController) {
        eventPanel = new EventPanel(this);
        cc = clientController;
    }

//    //displays the list of events
//    public LinkedList<Event> displayEventList(LinkedList<Event> events){
//        cc.update(up);
//        return events;
//    }
    //forward incoming event from client to GUI

    /**
     *
     * @param event
     */
        public void displayEvent(Event event) {
        //TODO: call method from GUI that displays the event in the GUI
        eventPanel.displayEvent(event);

    }

    /**
     * edits an existing event and updates the info to the database
     *
     * @return 
     */
    public Event editEvent() {
        event.setDescription(eventPanel.getDescription());
        event.setDate(eventPanel.getDate());

//        up.addEvent(event);
        return event;
    }

    /**
     *
     * @param description
     * @param date
     */
    public void sendEvent(String description, Date date) {
        cc.sendObject(new Event(description, cc.getUserId(), date, 0));
    }

    /**
     * delete an event by its Id
     *
     * @param obj
     */
    public void deleteEvent(Object obj) {
        cc.sendObjectToDelete(obj);

    }

    /**
     *
     * @param events
     */
    public void updatePanel(LinkedList<Event> events) {
        eventPanel.displayEventList(events);
    }

    /**
     *
     * @return
     */
    public EventPanel getPanel() {
        return eventPanel;
    }

}
