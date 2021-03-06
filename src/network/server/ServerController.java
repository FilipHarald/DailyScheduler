package network.server;

import java.sql.SQLException;

import javax.swing.JFrame;

import miscellaneous.*;
import database.DatabaseController;
import entities.*;
/**
 * 
 * @author Filip 
 *
 */
public class ServerController {
	
	private Server server;
	private DatabaseController dbc;
	
	public ServerController(int port){
		server = new Server(port, this);
		dbc = new DatabaseController();
		
	}
	
	
	public User authenticateUser(UsernameAndPwdPair unP){
		try {
			return dbc.authenticateUser(unP);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
			for(int recipient : ((Message) obj).getRecipients()){
				server.sendObject(recipient, obj);
				dbc.saveEntity(obj);
			}
		}else if(obj instanceof DeleteMe) {
			dbc.deleteEntity(((DeleteMe)obj).getObject());
		}else{			
			dbc.saveEntity(obj);
		}
	}
}
