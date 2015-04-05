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
	}
	
	public static void main(String[] args){
		ServerController controller = new ServerController();
	}
	
}
