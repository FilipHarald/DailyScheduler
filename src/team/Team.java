package team;

import java.util.LinkedList;

import user.User;

public class Team {
	private LinkedList<User> managers;
	private LinkedList<User> members;
	private String name;

	public Team(String name) {
		managers = new LinkedList<User>();
		members = new LinkedList<User>();
		this.name = name;
	}

	public LinkedList<User> getManagers() {
		return managers;
	}

	public LinkedList<User> getAllMembers() {
		return members;
	}

	public String getName() {
		return name;
	}
	
	public boolean addMember(User member){
		return members.add(member);
	}
	
	public boolean addManager(User manager){
		return members.add(manager);
	}

	public boolean removeManager(User manager) {
		return managers.remove(manager);
	}

	public boolean removeMember(User member) {
		return managers.remove(member);
	}
}
