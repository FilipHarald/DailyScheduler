/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.client;

import network.client.controllers.ClientController;
import entities.Event;
import network.client.controllers.EventController;
import entities.Task;
import network.client.controllers.TaskController;
import entities.Message;
import entities.Team;
import entities.User;
import network.client.controllers.UserAndTeamController;
import miscellaneous.UsernameAndPwdPair;

import java.io.*;
import java.net.*;
import java.util.Arrays;

import miscellaneous.Updater;
import network.server.Server;

/**
 *
 * @author Aya
 */
public class Client {
	private String userName;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Socket socket;

	private TaskController tc;
	private EventController ec;
	private UserAndTeamController utc;
	private Server server;
	private ClientController cc;
	private UsernameAndPwdPair auth;

	/*
	 * constructor: sets the ip, port and ID
	 */
	public Client(String ip, int port, ClientController cc) {
		this.cc = cc; 
		try {
			socket = new Socket(ip, port);
			// socket.connect(new InetSocketAddress(ip, port));
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * validates the users login with the server Also starts a new thread that
	 * maintains the connection to the server
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean validateUser(int userName, char[] password) {
		boolean validUser = false;
		try {
			oos.writeObject(new UsernameAndPwdPair(userName, password));
			oos.flush();
			validUser = ois.readBoolean();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (validUser) {
			new Listener().start();
		}
		return validUser;
	}

	public void send(Object obj) {
		try {
			oos.writeObject(obj);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class Listener extends Thread {
		Object object;

		public void run() {
			try {
				while (true) {
					System.out
							.println("this is the client Listener while-loop");
					object = ois.readObject();

					if (object instanceof Task) {
						Task task = (Task) object;
						tc.displayTask(task);
					} else if (object instanceof Event) {
						Event event = (Event) object;
						ec.displayEvent(event);
					} else if (object instanceof User) {
						User user = (User) object;
					} else if (object instanceof Team) {
						Team team = (Team) object;
					} else if (object instanceof Message){
						Message message = (Message) object;
					} else if (object instanceof Updater) {

						cc.update((Updater) object);
					}
				}
			} catch (IOException | ClassNotFoundException | NullPointerException e) {
				e.printStackTrace();
			}
		}

	}

	// close connection to server
	public void disconnect() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void refresh() {
		send("update");
	}

}
