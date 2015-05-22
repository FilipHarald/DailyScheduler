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

    /**
     * forward incoming event from client to GUI
     * @param event
     */
        public void displayEvent(Event event) {
        eventPanel.displayEvent(event);

    }

    /**
     * edits an existing event and updates the info to the database
     * @return 
     */
    public Event editEvent() {
        event.setDescription(eventPanel.getDescription());
        event.setDate(eventPanel.getDate());

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
     * @param obj
     */
    public void deleteEvent(Event event) {
        cc.sendObjectToDelete(event);

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
