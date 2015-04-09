package network.client.GUI;

import java.awt.BorderLayout;

import javax.swing.*;

import network.client.ClientController;
import network.client.GUI.panels.*;

public class ApplicationGUI extends JFrame{
	private ClientController clientController;
	
	private JPanel currentPanel;
	private MainButtonsPanel mainButtonsPanel;
	
	private CalendarPanel calendarPanel;
	private MessagePanel messagePanel;
	private TaskPanel taskPanel;
	
	public ApplicationGUI(String userName, ClientController clientController) {
		super("DailyScheduler - " + userName);
		this.clientController = clientController;
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainButtonsPanel = new MainButtonsPanel(this);
		add(mainButtonsPanel, BorderLayout.WEST);
		
		calendarPanel = new CalendarPanel();
		messagePanel = new MessagePanel();
		taskPanel = new TaskPanel();
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}

	public void changePanel(JPanel panel) {
		currentPanel = panel;
		repaint();
	}

	public void logOut() {
		clientController.logout();
	}
}
