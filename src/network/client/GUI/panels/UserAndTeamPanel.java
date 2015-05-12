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
	private AdminPanel adminPanel;
	private JButton createTeamButton;
	private JButton saveUserButton;
	private JButton addUserButton;

	public UserAndTeamPanel(UserAndTeamController userAndTeamController, boolean isAdmin) {
		super();
		this.uatC = userAndTeamController;
		setLayout(new GridLayout(0,2));
		setBorder(BorderFactory.createTitledBorder("User- and team view"));
		ButtonListener buttonListener = new ButtonListener();
		add(teamPanel = new TeamPanel(buttonListener));
		if(isAdmin){			
			add(adminPanel = new AdminPanel(buttonListener));
		}
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Object theButton = e.getSource();
			if(theButton == createTeamButton){
				teamPanel.sendTeam();
			}else if(theButton == saveUserButton){
				adminPanel.createUser();
			}else if (theButton == addUserButton){
				teamPanel.addUser();
			}
		}
	}
	
	private class TeamPanel extends JPanel {
		private JTextField teamIdField;
		private JTextField teamNameField;
		private JTextField userIdField;
		private JTextField teamIdForUserField;
		private JCheckBox isManager;
		
		public TeamPanel(ButtonListener buttonListener){
			setBorder(BorderFactory.createTitledBorder("Team"));
			
			JPanel addTeamPanel = new JPanel();
			addTeamPanel.setLayout(new BoxLayout(addTeamPanel, BoxLayout.PAGE_AXIS));
			addTeamPanel.setBorder(BorderFactory.createTitledBorder("Create new team"));
			addTeamPanel.add(new JLabel("If you wish to create a new team enter 0 as ID"));
			addTeamPanel.add(new JLabel("Enter team ID:"));
			addTeamPanel.add((teamIdField = new JTextField("", 10)));
			teamIdField.setMaximumSize(teamIdField.getPreferredSize());
			addTeamPanel.add(new JLabel("Enter team name:"));
			addTeamPanel.add((teamNameField = new JTextField("", 40)));
			teamNameField.setMaximumSize(teamNameField.getPreferredSize());
			
			createTeamButton = new JButton("Create team");
			createTeamButton.addActionListener(buttonListener);
			addTeamPanel.add(createTeamButton);
			
			JPanel addToTeamPanel = new JPanel();
			addToTeamPanel.setLayout(new BoxLayout(addToTeamPanel, BoxLayout.PAGE_AXIS));
			addToTeamPanel.setBorder(BorderFactory.createTitledBorder("Add user to a team"));
			addToTeamPanel.add(new JLabel("Enter user ID:"));
			addToTeamPanel.add((userIdField = new JTextField("", 10)));
			userIdField.setMaximumSize(userIdField.getPreferredSize());
			addToTeamPanel.add(new JLabel("Enter team ID to which the user will be added"));
			addToTeamPanel.add((teamIdForUserField = new JTextField("", 10)));
			teamIdForUserField.setMaximumSize(teamIdForUserField.getPreferredSize());
			
			addToTeamPanel.add((isManager = new JCheckBox("The user is going to be manager for this team")));
			
			addUserButton = new JButton("Add user");
			addUserButton.addActionListener(buttonListener);
			addToTeamPanel.add(addUserButton);
			
			setLayout(new GridLayout(2,0));
			add(addTeamPanel);
			add(addToTeamPanel);
		}

		public void addUser() {
			uatC.addUserToTeam(new Integer(teamIdForUserField.getText()),new Integer(userIdField.getText()), isManager.isSelected());
		}

		public void sendTeam() {
			uatC.sendTeam(new Integer(teamIdField.getText()) ,teamNameField.getText());
		}

	}

	private class AdminPanel extends JPanel {
		private JTextField nameField;
		private JCheckBox isAdmin;
		private JPasswordField passwordField;
		
		public AdminPanel(ButtonListener buttonListener) {
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
		
		

		public void createUser() {
			uatC.sendUser(nameField.getText(), isAdmin.isSelected(), passwordField.getText(), 0);
		}
	}
}
