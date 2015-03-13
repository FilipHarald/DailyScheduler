package team;

import java.util.LinkedList;

import user.User;

public class Team {
	private LinkedList<User> managers;
	private LinkedList<User> teamMembers;
	
	public Team(){
		managers = new LinkedList<User>();
		teamMembers = new LinkedList<User>();
	}
}
