package network.client.GUI.panels;

import java.awt.BorderLayout;

import javax.swing.*;

public class TestFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("test");
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		frame.add(new TaskPanel(null));
//                frame.add(new CalendarPanel(),BorderLayout.SOUTH);
//                frame.add(new MessagePanel(),BorderLayout.SOUTH);
		frame.add(new UserAndTeamPanel(null, true));
//		frame.add(new EventPanel(null));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		

	}

}
