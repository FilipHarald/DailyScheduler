package entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Representation of a team. The team can have more than one manager. Managers and members are separate lists.
 * The lists are synchronized separately.
 * 
 * @author Filip Harald
 *
 */

public class Team implements Serializable{
	private LinkedList<User> managers;
	private LinkedList<User> members;
	private int teamSize;
	private String name;
	private int Id;

	public Team(int Id, String name) {
		managers = new LinkedList<User>();
		members = new LinkedList<User>();
		this.name = name;
		teamSize = 0;
		this.Id = Id;
	}
	
	/**
	 * @return the ID of the team
	 */
	public int getId () {
		return Id;
	}
	
	/**
	 * @return the name of the team
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the size of the team, including managers
	 */
	public int getSize(){
		return teamSize;
	}

	/**
	 * @return an array of the managers in the team
	 */
	public synchronized User[] getManagers() {
		return managers.toArray(new User[0]);
	}

	/**
	 * @return an array of the members(not the managers) in the team
	 */
	public synchronized User[] getMembers() {
		return members.toArray(new User[0]);
	}
	
	/**
	 * @return an array of all the members in the team
	 */
	public synchronized User[] getTeam(){
		User[] temp = new User[teamSize];
		int counter = 0;
		for(User member : members){
			temp[counter++] = member; 
		}
		for(User manager : managers){
			temp[counter++] = manager; 
		}
		return temp;
	}
	
	public synchronized boolean addMember(User member){
		teamSize++;
		return members.add(member);
	}
	
	public synchronized boolean addManager(User manager){
		teamSize++;
		return managers.add(manager);
	}
	
	public boolean hasMember(User member){
		return members.contains(member);
	}
	
	public boolean hasManager(User manager){
		return managers.contains(manager);
	}

	public synchronized boolean removeManager(User manager) {
		teamSize--;
		return managers.remove(manager);
	}

	public synchronized boolean removeMember(User member) {
		teamSize--;
		return managers.remove(member);
	}
}
