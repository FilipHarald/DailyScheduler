package entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Representation of a team. The team can have more than one manager. Managers
 * and members are separate lists. The lists are synchronized separately.
 * 
 * @author Filip Harald
 *
 */

public class Team implements Serializable {
	private LinkedList<Integer> managers;
	private LinkedList<Integer> members;
	private int teamSize;
	private String name;
	private int Id;

	public Team(int Id, String name) {
		managers = new LinkedList<Integer>();
		members = new LinkedList<Integer>();
		this.name = name;
		teamSize = 0;
		this.Id = Id;
	}

	/**
	 * @return the ID of the team
	 */
	public int getId() {
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
	public int getSize() {
		return teamSize;
	}

	/**
	 * @return an array of the managers in the team
	 */
	public Integer[] getManagers() {
		return managers.toArray(new Integer[0]);
	}

	/**
	 * @return an array of the members(not the managers) in the team
	 */
	public Integer[] getMembers() {
		return members.toArray(new Integer[0]);
	}

	/**
	 * @return an array of all the members in the team
	 */
	public Integer[] getTeam() {
		Integer[] temp = new Integer[teamSize];
		int counter = 0;
		for (Integer member : members) {
			temp[counter++] = member;
		}
		for (Integer manager : managers) {
			temp[counter++] = manager;
		}
		return temp;
	}

	public boolean addMember(Integer memberId) {
		teamSize++;
		return members.add(memberId);
	}

	public boolean addManager(Integer managerId) {
		teamSize++;
		return managers.add(managerId);
	}

	public boolean hasMember(Integer memberId) {
		return members.contains(memberId);
	}

	public boolean hasManager(Integer managerId) {
		return managers.contains(managerId);
	}

	public boolean removeManager(Integer managerId) {
		teamSize--;
		return managers.remove(managerId);
	}

	public boolean removeMember(Integer memberId) {
		teamSize--;
		return managers.remove(memberId);
	}
}
