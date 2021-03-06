package network.client.controllers;

import entities.*;
import miscellaneous.DeleteMe;
import miscellaneous.Updater;
import network.client.Client;
import network.client.GUI.ApplicationGUI;
import network.client.GUI.LoginGUI;

/**
 * This class is a controller between the client(which is handling the
 * communication with the server) and the different GUIs (LoginGUI,
 * ApplicationGUI, and the panels)
 * 
 * @author Aya & Filip
 */
public class ClientController {
	private Client client;
	private LoginGUI loginWindow;
	private ApplicationGUI gui;
	private EventController ec;
	private TaskController tc;
	private MessageController mc;
	private UserAndTeamController uatc;
	private int userId;
	private boolean isAdmin;


	// constructor sets ip and port
	public ClientController(String serverIp, int port) {
		client = new Client(serverIp, port, this);
	}

	// start application
	public void startApplication() {
		loginWindow = new LoginGUI(this);
	}


	/**
	 * logs the user in if the username and password is valid
	 * 
	 * @param userName
	 *            the username of the user ("test")
	 * @param password
	 *            the password for the username ("1234")
	 */
	public void login(int userId, char[] password) {
		User usr = (User) client.validateUser(userId, password);
		if (usr != null) {
			loginWindow.close();
			this.userId = userId;
			this.isAdmin = usr.isAdmin();
			ec = new EventController(this);
			tc = new TaskController(this);
			mc = new MessageController(this);
			uatc = new UserAndTeamController(this);
			gui = new ApplicationGUI(null, this, ec.getPanel(), tc.getPanel(),
					mc.getPanel(), uatc.getPanel());
			client.startListening();
		} else {
			System.out.println("Fail!");
		}
	}

	// disconnect client when user logs out
	public void logout()  {
		client.disconnect();
	}

	public void refresh() {
		client.refresh();
	}

	public void update(Updater updater) {
		tc.updatePanel(updater.getTasks());
		mc.updatePanel(updater.getMessages());
		ec.updatePanel(updater.getEvents());
                if(isAdmin){
                    uatc.updatePanelUsers(updater.getUsers());
                }
		
		uatc.updatePanelTeams(updater.getTeams());
	}

	public void sendObject(Object obj) {
		client.send(obj);
	}

	public void sendObjectToDelete(Object obj) {
		client.send(new DeleteMe(obj));
	}

	public void newMessageReceived(Message m) {
		gui.displayMessage(m);
	}

	public int getUserId() {
		return userId;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
}
