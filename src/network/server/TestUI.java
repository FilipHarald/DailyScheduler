package network.server;

import javax.swing.JFrame;


public class TestUI {
	public void run() {
		JFrame frame = new JFrame("Server");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Server");
		frame.setResizable(true);
		frame.add(new ServerUI());
		frame.pack();
	}

	public static void main( String[] args) {
		TestUI ui = new TestUI();
		ui.run();	
	}
}