package network.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import network.server.Server.ClientHandler;

public class Server implements Runnable, Observer {
	
	private ServerSocket sSocket;
	private ServerController sCont;
	private ArrayList<ClientHandler> handlerList = new ArrayList<ClientHandler>();
	/**
	 * Starts the server socket. Will connect to controller.
	 * @param port The port.
	 * @param cont The Controller of this object.
	 */
	
	public Server(int port, ServerController sCont) { 
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
		while(true){
			try {
				Socket socket = sSocket.accept();
				ClientHandler ch = new ClientHandler(socket);
				ch.addObserver(this);
				new Thread(ch).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Sends an object to every connected client.
	 * @param obj
	 * @throws IOException
	 */
	public synchronized void broadcast(Object obj) throws IOException{
		for(ClientHandler ch : handlerList){
			ch.send(obj);
		}
	}

	@Override
	public synchronized void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Validates the username
	 * @param userName the username is "test" for now
	 * @return userName
	 */
	public boolean validateUserName(String userName){
		//TODO:Credentials need to be matched to the database, THIS IS A TEMPORARY SOLUTION
    	return (userName.equals("test"));
    }
    
	/**
	 * validates the password
	 * @param password the correct password is "1234" for now
	 * @return isCorrect
	 */
	public boolean validatePassword(char[] password) {
    	//TODO:Credentials need to be matched to the database, THIS IS A TEMPORARY SOLUTION
    	boolean isCorrect = true;
        char[] correctPassword = {'1', '2','3','4'};
        
        if (password.length != correctPassword.length){
            isCorrect = false;
        }else{
            isCorrect = Arrays.equals (password, correctPassword);
        }
        
        Arrays.fill(correctPassword, '0');
        
        return isCorrect;
        
    }
	
//	public void userConnected(String userName){
//		if (ID==true){
//			System.out.println("Test123 connected");
//		}
//	}
//	
	public String[] connectedUsers(){
		String[] temp = new String[handlerList.size()];
		for (int i = 0; i < handlerList.size(); i++) {
			temp[i] = handlerList.get(i).getName();
		}
		return temp;
	}
	
	/**
	 * Handles a connected client's input and output streams.
	 * @author Adam Henriksson
	 */
	public class ClientHandler extends Observable implements Runnable{
		private ObjectInputStream ois;
		private ObjectOutputStream oos;
		private String name;
		private Socket socket;
		
		/**
		 * Sets up the connecting socket.
		 * @param socket
		 */
		public ClientHandler(Socket socket){
			this.socket = socket;
		}
		
		/**
		 * Get the connected socket.
		 * @return The connected socket.
		 */
		public Socket getSocket(){
			return socket;
		}
		
		/**
		 * Gets the user name of the user this handler is connected to.
		 * @return The user name of the connected user.
		 */
		public String getName(){
			return name;
		}
		
		/**
		 * Gets the user name of the user this handler is connected to.
		 * @return The user name of the connected user.
		 */
		public String toString(){
			return name;
		}
		
		/**
		 * Sends the objects to all connected clients.
		 * @param obj
		 */
		public void send(Object obj){
			try {
				if(oos != null){
					oos.writeObject(obj);
					oos.flush();
				} else
					System.out.println("No output stream");
			} catch (SocketException e){
				try {
					if(oos != null)
						oos.close();
				} catch (IOException e1) { }
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
				ois = new ObjectInputStream(socket.getInputStream());
				oos = new ObjectOutputStream(socket.getOutputStream());
				
				while(true){
					Object obj = ois.readObject();
					if(obj instanceof String)						
						name = (String) obj;
					setChanged();
					notifyObservers(obj);	
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch(SocketException e){
				try {
					socket.close();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			catch (IOException e) {
				try {
					ois.close();
					oos.close();
					socket.close();
				} catch (IOException e1) { }
			}
		}
	}

}
