package network.client.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

public class GUIDailySchedulerApp {


	public void start(){
		/*
		 * Body
		 * är dett verkligen tillräckligt med kommentarer?
		 */
		JFrame frame = new JFrame("Server GUI");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//		GUIDailySchedulerPanel.setPreferredSize(new Dimension(10,10));
//		frame.add(new GUIDailySchedulerPanel());
		frame.setSize(800, 600);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
	}

	public static void main (String[] args){
		GUIDailySchedulerApp test = new GUIDailySchedulerApp();
		test.start();
	}

}
