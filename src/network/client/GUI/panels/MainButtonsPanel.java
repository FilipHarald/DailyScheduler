package network.client.GUI.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import network.client.GUI.ApplicationGUI;

public class MainButtonsPanel extends JPanel {
	private ApplicationGUI applicationGUI;
	private JButton mainButton;
	private JButton taskButton;
	private JButton messageButton;
	private JButton calendarButton;
	private JButton salariesButton;
	private JButton logOutButton;

	public MainButtonsPanel(ApplicationGUI applicationGUI){
		super();
		this.applicationGUI = applicationGUI;
		setBorder(BorderFactory.createTitledBorder("Menu"));
		setPreferredSize(new Dimension(200, 10));
		
		mainButton = new JButton("Main Screen");
		taskButton = new JButton("Tasks");
		messageButton = new JButton("Messages");
		calendarButton = new JButton("Calendar");
		salariesButton = new JButton("Salaries");
		logOutButton = new JButton("Log out");
		logOutButton.setFont(logOutButton.getFont().deriveFont(Font.BOLD | Font.ITALIC));
		
		mainButton.addActionListener(new ButtonListener());
		add(mainButton);
		add(taskButton);
		add(messageButton);
		add(calendarButton);
		add(salariesButton);
		add(logOutButton);
	}
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String actionString = e.getActionCommand();
			
			switch (actionString) {
            	case "Log out":	System.out.println("lolol");
                    	break;
            	case "lol": actionString = "Maasfin Screen";
            			break;
            	default: actionString = "Invalid month";
            			break;
			}
		}
		
	}
}
