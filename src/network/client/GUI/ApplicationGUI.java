package network.client.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import network.client.controllers.ClientController;
import network.client.GUI.panels.*;

public class ApplicationGUI extends JFrame {

    private ClientController clientController;
    private Container contentPane;
    
    
	public ApplicationGUI(String userName, ClientController clientController, EventPanel eP, TaskPanel tP, MessagePanel mP) {
		super("DailyScheduler - " + userName);
		contentPane = getContentPane();
		this.clientController = clientController;
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        contentPane.add(setComponents(eP, tP, mP), BorderLayout.SOUTH);

    }

    public JPanel setComponents(EventPanel eP, TaskPanel tP, MessagePanel mP) {
    	JPanel pnlButtons = new JPanel();
    	
    	JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.add("Welcome", new WelcomePanel());
		tabbedPane.add("Messages", mP);
		tabbedPane.add("Tasks", tP);
        tabbedPane.add("Event", eP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

        
		JButton logOutButton = new JButton("Log out");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logOut();
			}
		});
		
		JButton refreshButton = new JButton("Refresh");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}

		});

		pnlButtons.setLayout(new BorderLayout());
		pnlButtons.add(logOutButton, BorderLayout.EAST);
		pnlButtons.add(refreshButton, BorderLayout.WEST);
		
       
        logOutButton.setFont(logOutButton.getFont().deriveFont(
                Font.BOLD | Font.ITALIC));
       
        refreshButton.setFont(refreshButton.getFont().deriveFont(
                Font.BOLD | Font.ITALIC));
        return pnlButtons;
    }

    private void refresh() {
        clientController.refresh();

    }

    public void logOut() {
        try {
            clientController.logout();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dispose();
    }
}