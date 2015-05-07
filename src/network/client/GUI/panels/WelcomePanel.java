package network.client.GUI.panels;

import java.awt.Dimension;

import javax.swing.*;

public class WelcomePanel extends JPanel  {

	public WelcomePanel(){
		super();
		setBorder(BorderFactory.createTitledBorder("Welcome"));
		setPreferredSize(new Dimension(400, 400));
		add(new JLabel("You are very much welcome to this first panel"));
	}
}
