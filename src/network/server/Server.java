package network.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import miscellaneous.UsernameAndPwdPair;
import network.server.Server.ClientHandler;

public class Server implements Runnable {

	private ServerSocket sSocket;
	private ServerController sCont;
	private HashMap<Integer, ClientHandler> clientHandlerMap;

	/**
	 * Starts the server socket. Will connect to controller.
	 * 
	 * @param port
	 *            The port.
	 * @param cont
	 *            The Controller of this object.
	 */

	public Server(int port, ServerController sCont) {
		clientHandlerMap = new HashMap<Integer, ClientHandler>();
		try {
			this.sCont = sCont;
			sSocket = new ServerSocket(port);
			new Thread(this).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("listening for clients");
				Socket socket = sSocket.accept();
				System.out.println("client connected to serverSocket");
				ClientHandler ch = new ClientHandler(socket);
				new Thread(ch).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void sendObject(int recipient, Object obj) {
		ClientHandler temp = clientHandlerMap.get(recipient);
		if (temp != null) {
			temp.send(obj);
		}
	}

	/**
	 * Handles a connected client's input and output streams.
	 * 
	 * @author Adam Henriksson
	 */
	public class ClientHandler implements Runnable {
		private ObjectInputStream ois;
		private ObjectOutputStream oos;
		private int userId;

		/**
		 * Sets up the connecting socket.
		 * 
		 * @param socket
		 */
		public ClientHandler(Socket socket) {
			try {
				oos = new ObjectOutputStream(socket.getOutputStream());
				ois = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public String getName() {
			return null;
		}

		/**
		 * Gets the user name of the user this handler is connected to.
		 * 
		 * @return The user name of the connected user.
		 */
		public int getUserId() {
			return userId;
		}

		/**
		 * Sends the objects to all connected clients.
		 * 
		 * @param obj
		 */
		public void send(Object obj) {
			try {
				oos.writeObject(obj);
				oos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		/**
		 * Allows the ClientHandler to read objects.
		 */
		@Override
		public void run() {
			try {
				System.out.println("clientHandler thread started");
				UsernameAndPwdPair unP;
				while (true) {
					unP = (UsernameAndPwdPair) ois.readObject();
					Object usr = sCont.authenticateUser(unP);
					oos.writeObject(usr);
					oos.flush();
					if (usr != null) {
						userId = unP.getUserId();
						clientHandlerMap.put(userId, this);
						System.out.println("User is valid while-loop starting");
						while (true) {
							oos.writeObject(sCont.getUpdater(userId));
							Object obj = ois.readObject();
                                                        System.out.println("6" + obj);
							if (obj.equals("update")) {
								// no code needed, this is just intended to
								// re-do the loop and update the client
							} else {
								sCont.objectRecivied(obj);
							}
						}
					}

				}

			} catch (ClassNotFoundException | IOException | SQLException e) {
				e.printStackTrace();

			}
		}
	}
}
