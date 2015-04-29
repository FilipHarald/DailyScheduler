package network.server;

import java.sql.SQLException;

import javax.swing.JFrame;

import miscellaneous.*;
import database.DatabaseController;
import entities.*;

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

	public Updater getUpdater(int userId) {
		try {
			return dbc.getUpdater(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public void objectRecivied(Object obj) throws SQLException {
		if(obj instanceof Message){
			dbc.saveEntity(obj);
			
		}
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
