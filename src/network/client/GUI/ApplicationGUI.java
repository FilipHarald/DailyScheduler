package network.client.GUI;

import java.awt.BorderLayout;

import javax.swing.*;

import network.client.GUI.panels.*;

public class ApplicationGUI {
	private JFrame frame;
	
	private JPanel currentPanel;
	private MainButtonsPanel mainButtonsPanel;
	
	private CalendarPanel calendarPanel;
	private MessagePanel messagePanel;
	private TaskPanel taskPanel;
	
	public ApplicationGUI(String userName) {
		JFrame frame = new JFrame("DailyScheduler - " + userName);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainButtonsPanel = new MainButtonsPanel();
		frame.add(mainButtonsPanel, BorderLayout.WEST);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		
	}

	public void changePanel(JPanel panel) {
		currentPanel = panel;
		frame.repaint();
	}
}
