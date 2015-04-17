package network.server;

import javax.swing.JFrame;

import miscellaneous.UsernameAndPwdPair;
import database.DatabaseController;

public class ServerController {
	
	public final int port = 1234;
	private Server server = new Server(port, this);
	private DatabaseController dbc;
	public ServerController(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new ServerUI());
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
	public boolean authenticateUser(UsernameAndPwdPair unP){
		return dbc.authenticateUser(unP);
	}
	
	
	
	public void checkID(){
		
	}
	
	/**
	 * Handles objects coming in from the server.
	 * @param arg Object to be handled.
	 */	
	public void objectHandler(Object arg){
		if(arg instanceof String){
			userConnected((String) arg);
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
	
	public static void main(String[] args){
		ServerController controller = new ServerController();
	}
	
}
