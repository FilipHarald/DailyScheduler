/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.client.controllers;

import java.io.IOException;

import javax.swing.JFrame;

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

	// constructor sets ip and port
	public ClientController(String serverIp, int port) {
		ip = serverIp;
		this.port = port;
		client = new Client(serverIp, port);
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
	public void login(String userName, char[] password) {
		if (client.validateUser(userName, password) == true) {
			loginWindow.close();
			gui = new ApplicationGUI(null, this);
		} else {
			System.out.println("Fail!");
		}
	}

	// disconnect client when user logs out
	public void logout() {
		try {
			client.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}