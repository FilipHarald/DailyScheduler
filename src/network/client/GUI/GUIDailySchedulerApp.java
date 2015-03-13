package network.client.GUI;

import java.awt.BorderLayout;

import javax.swing.*;

public class GUIDailySchedulerApp {


	public void start(){
		/*
		 * Body
		 * är dett verkligen tillräckligt med kommentarer?
		 */
		JFrame frame = new JFrame("Server GUI");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		frame.setResizable(false);
		frame.add(new GUIDailySchedulerPanel());
		frame.pack();
		frame.setVisible(true);
		
		
	}

	public static void main (String[] args){
		GUIDailySchedulerApp test = new GUIDailySchedulerApp();
		test.start();
	}

}
