package network.client.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import network.client.ClientController;
import network.client.GUI.panels.*;

public class ApplicationGUI extends JFrame {
	private ClientController clientController;

	private Container contentPane;

	private CalendarPanel calendarPanel;
	private MessagePanel messagePanel;
	private TaskPanel taskPanel;

	public ApplicationGUI(String userName, ClientController clientController) {
		super("DailyScheduler - " + userName);
		contentPane = getContentPane();
		this.clientController = clientController;

		setComponents();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);

	}

	public void setComponents() {

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.add("Welcome", new WelcomePanel());
		tabbedPane.add("Messages", new MessagePanel());
		tabbedPane.add("Tasks", new TaskPanel());
                tabbedPane.add("Calendar", new CalendarPanel());
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JButton logOutButton = new JButton("Log out");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logOut();
			}
		});

		add(logOutButton, BorderLayout.SOUTH);
		logOutButton.setFont(logOutButton.getFont().deriveFont(
				Font.BOLD | Font.ITALIC));
	}

	public void logOut() {
		clientController.logout();
		dispose();
	}
}
