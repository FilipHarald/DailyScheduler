package network.server;

import java.sql.SQLException;

import javax.swing.JFrame;

import miscellaneous.*;
import database.DatabaseController;

public class ServerController {
	
	private Server server;
	private DatabaseController dbc;
	
	public ServerController(int port){
		server = new Server(port, this);
		dbc = new DatabaseController();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new ServerUI());
		frame.pack();
		frame.setVisible(true);
		
	}
	
	
	public boolean authenticateUser(UsernameAndPwdPair unP){
		try {
			return dbc.authenticateUser(unP);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public void checkID(){
		
	}
	
	/**
	 * Handles objects coming in from the server.
	 * @param arg Object to be handled.
	 */	
	public void objectHandler(Object arg){
		if(arg instanceof String){
//			userConnected((String) arg);
		}
		
	}


	public Updater getUpdater(int userId) {
		Updater updater = new Updater();
		//get useful information(for the user with userId) from database and store in updater here
		return updater;
	}

	
	/**
	 * Sends objects to all connected clients.
	 * @param obj Object to be sent to all connected clients.
	 * @throws IOException Thrown due to connection issues.
	 */
	//public void broadcast(Object obj) throws IOException{
		//server.broadcast(obj);
	//}
	

	
}
