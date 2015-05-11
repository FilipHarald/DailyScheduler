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
 * @author Aya & Filip
 */
public class Client {
	private String userId;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Socket socket;
	private ClientController cc;

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
	public Object validateUser(int userName, char[] password) {
		Object validUser = false;
		try {
			oos.writeObject(new UsernameAndPwdPair(userName, password));
			oos.flush();
			validUser = ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return validUser;
	}
	public void startListening(){
		new Listener().start();
	}

	public void send(Object obj) {
		try {
			oos.writeObject(obj);
                        System.out.println("5" + obj);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

        public void sendToDelete(Object obj) {
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

					if (object instanceof Message){
						cc.newMessageReceived((Message) object);
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
