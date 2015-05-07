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
	private JButton saveTeamButton;
	private JButton saveUserButton;

	public UserAndTeamPanel(UserAndTeamController userAndTeamController) {
		super();
		this.uatC = userAndTeamController;
		setLayout(new GridLayout(0,2));
		setBorder(BorderFactory.createTitledBorder("User- and team view"));
		ButtonListener buttonListener = new ButtonListener();
		add(teamPanel = new TeamPanel(buttonListener));
		add(userPanel = new UserPanel(buttonListener));
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Object theButton = e.getSource();
			if(theButton == saveTeamButton){
				teamPanel.sendTeam();
			}else if(theButton == saveUserButton){
				userPanel.sendUser();
			}
		}
	}
	
	private class TeamPanel extends JPanel {
		private JTextField teamIdField;
		private JTextField teamNameField;
		
		public TeamPanel(ButtonListener buttonListener){
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			setBorder(BorderFactory.createTitledBorder("Team"));
			add(new JLabel("If you wish to create a new team enter 0 as ID"));
			
			add(new JLabel("Enter team ID:"));
			add((teamIdField = new JTextField("", 10)));
			teamIdField.setMaximumSize(teamIdField.getPreferredSize());
			
			add(new JLabel("Enter team name:"));
			add((teamNameField = new JTextField("", 40)));
			teamNameField.setMaximumSize(teamNameField.getPreferredSize());
			
			saveTeamButton = new JButton("Save team");
			saveTeamButton.addActionListener(buttonListener);
			add(saveTeamButton);
		}

		public void sendTeam() {
			uatC.sendTeam(new Integer(teamIdField.getText()) ,teamNameField.getText());
		}

	}

	private class UserPanel extends JPanel {
		private JTextField nameField;
		private JCheckBox isAdmin;
		private JPasswordField passwordField;
		
		public UserPanel(ButtonListener buttonListener) {
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			setBorder(BorderFactory.createTitledBorder("User"));
			
			add(new JLabel("Enter name:"));
			add((nameField = new JTextField("", 40)));
			nameField.setMaximumSize(nameField.getPreferredSize());
			
			add(new JLabel("Enter desired password:"));
			add((passwordField = new JPasswordField("", 40)));
			passwordField.setMaximumSize(passwordField.getPreferredSize());
			
			add((isAdmin = new JCheckBox("The user will have admin rights")));
			saveUserButton = new JButton("Create user");
			saveUserButton.addActionListener(buttonListener);
			add(saveUserButton);
		}

		public void sendUser() {
			uatC.sendUser(nameField.getText(), isAdmin.isSelected(), passwordField.getText(), 0);
		}
	}
}
