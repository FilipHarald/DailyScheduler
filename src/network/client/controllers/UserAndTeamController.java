
package network.client.controllers;

import java.util.LinkedList;

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
		uatPanel = new UserAndTeamPanel(this, cc.isAdmin());
	}
	
	public void sendUser(String name, boolean isAdmin, String password, int Id){
		cc.sendObject(new User(name, isAdmin, password, Id));
	}
	
	public void sendTeam(int Id, String name){
		cc.sendObject(new Team(Id, name));
	}
	public void addUserToTeam(int teamId, int userId, boolean isManager){
		Team team = new Team(teamId, null);
		if(isManager){
			team.addManager(new Integer(userId));
		}else{			
			team.addMember(new Integer(userId));
		}
		cc.sendObject(team);
	}

	public UserAndTeamPanel getPanel() {
		return uatPanel;
	}

	public void updatePanelUsers(LinkedList<User> users) {
		uatPanel.updateUserList(users);
	}

	public void updatePanelTeams(LinkedList<Team> teams) {
		uatPanel.updateTeamList(teams);
	}
}
