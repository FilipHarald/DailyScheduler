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

	public MainButtonsPanel(ApplicationGUI applicationGUI) {
		super();
		this.applicationGUI = applicationGUI;
		setBorder(BorderFactory.createTitledBorder("Menu"));
		setPreferredSize(new Dimension(200, 10));
		addButtons();
	}

	public void addButtons() {
		mainButton = new JButton("Main Screen");
		taskButton = new JButton("Tasks");
		messageButton = new JButton("Messages");
		calendarButton = new JButton("Calendar");
		salariesButton = new JButton("Salaries");
		logOutButton = new JButton("Log out");

		logOutButton.setFont(logOutButton.getFont().deriveFont(
				Font.BOLD | Font.ITALIC));

		mainButton.setActionCommand("main");
		taskButton.setActionCommand("task");
		messageButton.setActionCommand("message");
		calendarButton.setActionCommand("calendar");
		salariesButton.setActionCommand("salaries");
		logOutButton.setActionCommand("log out");

		mainButton.addActionListener(new ButtonListener());
		taskButton.addActionListener(new ButtonListener());
		messageButton.addActionListener(new ButtonListener());
		calendarButton.addActionListener(new ButtonListener());
		salariesButton.addActionListener(new ButtonListener());
		logOutButton.addActionListener(new ButtonListener());

		add(mainButton);
		add(taskButton);
		add(messageButton);
		add(calendarButton);
		add(salariesButton);
		add(logOutButton);
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String command = e.getActionCommand();
			switch (command) {
			case "log out":
				applicationGUI.logOut();
				break;
			default:
				applicationGUI.changePanel(command);
				break;
			}
		}

	}
}
