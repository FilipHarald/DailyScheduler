package miscellaneous;

import java.io.Serializable;
import java.util.LinkedList;

import entities.*;
/**
 * This class is used to send necessary information from the Database on the server-side to the client (with a user logged-in)
 * @author Filip
 *
 */
public class Updater implements Serializable {
	private LinkedList<Event> events;
	private LinkedList<Message> messages;
	private LinkedList<Task> tasks;
	private LinkedList<User> users;
	private LinkedList<Team> teams;
	
	public Updater(){
		events = new LinkedList<Event>();
		messages = new LinkedList<Message>();
		tasks = new LinkedList<Task>();
		users = new LinkedList<User>();
		teams = new LinkedList<Team>();
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

	public LinkedList<User> getUsers() {
		return users;
	}
	
	public void addUser(User user){
		users.add(user);
	}

	public LinkedList<Team> getTeams() {
		return teams;
	}	
	
	public void addTeam(Team team){
		teams.add(team);
	}
}
