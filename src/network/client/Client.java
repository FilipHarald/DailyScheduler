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
import entities.Team;
import entities.User;
import network.client.controllers.UserAndTeamController;
import miscellaneous.UsernameAndPwdPair;

import java.io.*;
import java.net.*;
import java.util.Arrays;

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
	public Client(String ip, int port) {
		try {
			System.out.println("11");
			socket = new Socket();
			socket.connect(new InetSocketAddress(ip, port));
			System.out.println("12");
			System.out.println(socket.toString());
			ois = new ObjectInputStream(socket.getInputStream());
			System.out.println("13");
			oos = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("14");


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
	public boolean validateUser(String userName, char[] password) {
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

	// send task to server
	public void sendTask(Task task) {

		try {
			oos.writeObject(task);
			oos.flush();
		} catch (IOException e) {
		}
	}

	// send event to server
	public void sendEvent(Event event) {
		try {
			oos.writeObject(event);
			oos.flush();
		} catch (IOException e) {
		}
	}

	// send created user to server
	public void sendUser(User user) {
		try {
			oos.writeObject(user);
			oos.flush();
		} catch (IOException e) {
		}
	}

	// send team to server
	public void sendTeam(Team team) {
		try {
			oos.writeObject(team);
			oos.flush();
		} catch (IOException e) {
		}
	}

	/**
	 * send userName to server via oos incoming object can be instance of task,
	 * event, user or team.
	 * 
	 */
	private class Listener extends Thread {
		Object object;

		public void run() {
			try {
				while (true) {
					System.out.println("this is the client Listener while-loop");
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
					}
				}
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	// close connection to server
	public void disconnect(){
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
