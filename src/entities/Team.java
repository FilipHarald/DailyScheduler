package entities;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Representation of a team. The team can have more than one manager. Managers and members are separate lists.
 * The lists are synchronized separately.
 * 
 * @author Filip Harald
 *
 */

public class Team {
	private LinkedList<User> managers;
	private LinkedList<User> members;
	private int teamSize;
	private String name;

	public Team(String name) {
		managers = (LinkedList<User>) Collections.synchronizedList(new LinkedList<User>());
		members = (LinkedList<User>) Collections.synchronizedList(new LinkedList<User>());
		this.name = name;
		teamSize = 0;
	}
	
	public String getTeamName() {
		return name;
	}
	
	public int getTeamSize(){
		return teamSize;
	}

	/**
	 * @return An array of the managers in the team.
	 */
	public User[] getManagers() {
		return (User[]) managers.toArray();
	}

	/**
	 * @return An array of the members(not the managers) in the team.
	 */
	public User[] getMembers() {
		return (User[]) members.toArray();
	}
	
	/**
	 * @return An array of all the members in the team.
	 */
	public User[] getTeam(){
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
	
	public boolean addMember(User member){
		teamSize++;
		return members.add(member);
	}
	
	public boolean addManager(User manager){
		teamSize++;
		return members.add(manager);
	}
	
	public boolean hasMember(User member){
		return members.contains(member);
	}
	
	public boolean hasManager(User manager){
		return members.contains(manager);
	}

	public boolean removeManager(User manager) {
		teamSize--;
		return managers.remove(manager);
	}

	public boolean removeMember(User member) {
		teamSize--;
		return managers.remove(member);
	}
}
