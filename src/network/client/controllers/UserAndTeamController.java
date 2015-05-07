/**
 * 
 */
package network.client.controllers;

import entities.Team;
import entities.User;
import network.client.GUI.panels.UserAndTeamPanel;

/**
 * @author Filip
 *
 */
public class UserAndTeamController {
	
	private ClientController cc;
	private UserAndTeamPanel uatPanel;
	
	public UserAndTeamController(ClientController cc){
		this.cc = cc;
		uatPanel = new UserAndTeamPanel(this);
	}
	
	public void sendUser(String name, boolean isAdmin, String password, int Id){
		cc.sendObject(new User(name, isAdmin, password, Id));
	}
	
	public void sendTeam(int Id, String name){
		cc.sendObject(new Team(Id, name));
	}
	public void addUserToTeam(int teamId, int userId){
		
	}
}
