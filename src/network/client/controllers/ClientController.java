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
	private String ip;
	private int port;
	private LoginGUI loginWindow;
	private ApplicationGUI gui;
	private Server server;
	private EventController ec;
	private TaskController tc;
	private MessageController mc;

	// constructor sets ip and port
	public ClientController(String serverIp, int port) {
		ip = serverIp;
		this.port = port;
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
			mc = new MessageController();
			gui = new ApplicationGUI(null, this, ec.getPanel(), tc.getPanel(), mc.getPanel());
			client.startListening();
		} else {
			System.out.println("Fail!");
		}
	}

	// disconnect client when user logs out
	public void logout() throws IOException {
		client.disconnect();
	}

//	public Updater updateGui() {
//		Updater updater = null;
//		Object object = updater;
//		// updater.addEvent(event);
//		// updater.addMessage(message);
//		// updater.addTask(task);
//
//		// Object object;
//		// object = updater;
//
//		if (object instanceof Event) {
//			Event event = (Event) object;
//			updater.addEvent(event);
//			updater.getEvents();
//			ec.displayEventList(event);
//
//		} else if (object instanceof Message) {
//			Message msg = (Message) object;
//			updater.addMessage(msg);
//			updater.getMessages();
//
//		} else if (object instanceof Task) {
//			Task task = (Task) object;
//			updater.addTask(task);
//			updater.getTasks();
//			tc.displayTaskList(task);
//		}
//
//		return updater;
//
//	}

	public void refresh() {
		client.refresh();
	}

	public void update(Updater updater) {
        tc.updatePanel(updater.getTasks());
        mc.updatePanel(updater.getMessages());
        ec.updatePanel(updater.getEvents());
    }
}
