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

<<<<<<< HEAD
    private JPanel pnlButtons = new JPanel();

    JButton logOutButton = new JButton("Log out");
    JButton refreshButton = new JButton("Refresh");
=======
	public ApplicationGUI(String userName, ClientController clientController, EventPanel eP, TaskPanel tP, MessagePanel mP) {
		super("DailyScheduler - " + userName);
		contentPane = getContentPane();
		this.clientController = clientController;

		setComponents(eP, tP, mP);
>>>>>>> lite ändringar

    private EventPanel eventPanel;
    private MessagePanel messagePanel;
    private TaskPanel taskPanel;

    public ApplicationGUI(String userName, ClientController clientController) {
        super("DailyScheduler - " + userName);
        contentPane = getContentPane();
        this.clientController = clientController;

<<<<<<< HEAD
        setComponents();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        pnlButtons.setLayout(new BorderLayout());
        pnlButtons.add(logOutButton, BorderLayout.EAST);
        pnlButtons.add(refreshButton, BorderLayout.WEST);

        contentPane.add(pnlButtons, BorderLayout.SOUTH);

    }

    public void setComponents() {

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Welcome", new WelcomePanel());
        tabbedPane.add("Messages", new MessagePanel());
        tabbedPane.add("Tasks", new TaskPanel());
        tabbedPane.add("Event", new EventPanel());
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        
        logOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logOut();
            }
        });

        
        logOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refresh();
            }

        });

       
        logOutButton.setFont(logOutButton.getFont().deriveFont(
                Font.BOLD | Font.ITALIC));
       
        refreshButton.setFont(refreshButton.getFont().deriveFont(
                Font.BOLD | Font.ITALIC));
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
=======
	public void setComponents(EventPanel eP, TaskPanel tP, MessagePanel mP) {

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

		add(logOutButton, BorderLayout.SOUTH);
		logOutButton.setFont(logOutButton.getFont().deriveFont(
				Font.BOLD | Font.ITALIC));
		add(refreshButton, BorderLayout.SOUTH);
		refreshButton.setFont(refreshButton.getFont().deriveFont(
				Font.BOLD | Font.ITALIC));
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
>>>>>>> lite ändringar
}
