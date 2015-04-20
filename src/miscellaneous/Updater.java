package miscellaneous;

import java.util.LinkedList;

import entities.*;

public class Updater {
	private LinkedList<Event> events;
	private LinkedList<Message> messages;
	private LinkedList<Task> tasks;
	
	public Updater(){
		events = new LinkedList<Event>();
		messages = new LinkedList<Message>();
		tasks = new LinkedList<Task>();
	}
	
	public LinkedList<Event> getEvents() {
		return events;
	}

	public void addEvent(Event event) {
		events.add(event);
	}

	public LinkedList<Message> getMessages() {
		return messages;
	}

	public void addMessage(Message message) {
		messages.add(message);
	}

	public LinkedList<Task> getTasks() {
		return tasks;
	}

	public void addTask(Task task) {
		tasks.add(task);
	}		
}
