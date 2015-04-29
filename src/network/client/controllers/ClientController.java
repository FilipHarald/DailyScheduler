/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.client.controllers;

import java.io.IOException;

import javax.swing.JFrame;

import entities.*;
import miscellaneous.Updater;
import network.client.Client;
import network.client.GUI.ApplicationGUI;
import network.client.GUI.LoginGUI;
import network.server.Server;

/**
 *
 * @author Aya
 */
public class ClientController {
	private Client client;
	private LoginGUI loginWindow;
	private ApplicationGUI gui;
	private EventController ec;
	private TaskController tc;
	private MessageController mc;
	private int userId;

	// constructor sets ip and port
	public ClientController(String serverIp, int port) {
		client = new Client(serverIp, port, this);
	}

	// start application
	public void startApplication() {
		loginWindow = new LoginGUI(this);
	}

	// TODO: send obj to server (T||E||U||Te)

	/**
	 * logs the user in if the username and password is valid
	 * 
	 * @param userName
	 *            the username of the user ("test")
	 * @param password
	 *            the password for the username ("1234")
	 */
	public void login(int userId, char[] password) {
		if (client.validateUser(userId, password) == true) {
			loginWindow.close();
			ec = new EventController();
			tc = new TaskController();
			mc = new MessageController(this);
			gui = new ApplicationGUI(null, this, ec.getPanel(), tc.getPanel(), mc.getPanel());
			this.userId = userId;
			client.startListening();
		} else {
			System.out.println("Fail!");
		}
	}

	// disconnect client when user logs out
	public void logout() throws IOException {
		client.disconnect();
	}

	public void refresh() {
		client.refresh();
	}

	public void update(Updater updater) {
        tc.updatePanel(updater.getTasks());
        mc.updatePanel(updater.getMessages());
        ec.updatePanel(updater.getEvents());
    }
	public void sendObject(Object obj){
		client.send(obj);
	}
	

	public void newMessageReceived(Message m) {
		gui.displayMessage(m);
	}
	
	public int getUserId(){
		return userId;
	}
}
