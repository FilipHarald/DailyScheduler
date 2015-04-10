package network.server;

import javax.swing.JFrame;

public class ServerController {
	
	public final int port = 1234;
	private Server server = new Server(port, this);
	
	
	
	public ServerController(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new ServerUI());
		frame.pack();
		frame.setVisible(true);
		
		try {
			if(new File(System.getProperty("user.dir") + "/allUsers.dat").isFile()){
				ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(
						new FileInputStream(System.getProperty("user.dir") + "/allUsers.dat")));
				allUsers = (List<String>) ois.readObject();
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void userConnected(String user){
		ui.userConnected(user);
		refreshConnectedList();
		
		if(!allUsers.contains(user))
			allUsers.add(user);
		
		try {
			FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/allUsers.dat");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(allUsers);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public void broadcast(Object obj) throws IOException{
		server.broadcast(obj);
	}
	
	public static void main(String[] args){
		ServerController controller = new ServerController();
	}
	
}
