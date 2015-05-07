/**
 * 
 */
package network.client.GUI.panels;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import network.client.controllers.UserAndTeamController;

/**
 * @author Filip
 *
 */
public class UserAndTeamPanel extends JPanel {
	private UserAndTeamController uatC;
	private TeamPanel teamPanel;
	private UserPanel userPanel;
	private JButton saveTeam;
	private JButton saveUser;

	public UserAndTeamPanel(UserAndTeamController userAndTeamController) {
		super();
		this.uatC = userAndTeamController;
		setLayout(new GridLayout(0,2));
		setBorder(BorderFactory.createTitledBorder("User- and team view"));
		ButtonListener buttonListener = new ButtonListener();
		add(new TeamPanel(buttonListener));
		add(new UserPanel(buttonListener));
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Object theButton = e.getSource();
			if(theButton == saveTeam){
				teamPanel.sendTeam();
			}else if(theButton == saveUser){
				userPanel.sendUser();
			}
		}
	}
	
	private class TeamPanel extends JPanel {
		private JTextField teamIdField;
		private JTextField teamNameField;
		
		public TeamPanel(ButtonListener buttonListener){
			add(new JLabel("If you wish to create a new team enter 0 as ID"));
			add((teamIdField = new JTextField("Enter team ID")));
			add((teamNameField = new JTextField("Enter team name")));
			saveTeam = new JButton("Save team");
			saveTeam.addActionListener(buttonListener);
		}

		public void sendTeam() {
			uatC.sendTeam(new Integer(teamIdField.getText()) ,teamNameField.getText());
		}

	}

	private class UserPanel extends JPanel {
		private JTextField usernameField;
		private JCheckBox isAdmin;
		private JPasswordField passwordField;
		
		public UserPanel(ButtonListener buttonListener) {
			add((usernameField = new JTextField("Enter username")));
			add((isAdmin = new JCheckBox("The user will have admin rights")));
			add((passwordField = new JPasswordField("Enter password")));
			saveUser = new JButton("Create user");
			saveUser.addActionListener(buttonListener);
		}

		public void sendUser() {
			uatC.sendUser(usernameField.getText(), isAdmin.isSelected(), passwordField.getText(), 0);
		}
	}
}
