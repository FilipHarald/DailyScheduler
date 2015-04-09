package network.client.GUI;

import java.awt.BorderLayout;

import javax.swing.*;

import network.client.GUI.panels.*;

public class ApplicationGUI extends JFrame{
	
	private JPanel currentPanel;
	private MainButtonsPanel mainButtonsPanel;
	
	private CalendarPanel calendarPanel;
	private MessagePanel messagePanel;
	private TaskPanel taskPanel;
	
	public ApplicationGUI(String userName) {
		super("DailyScheduler - " + userName);
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
}
