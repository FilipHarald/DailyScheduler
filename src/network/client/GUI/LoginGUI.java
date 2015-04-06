package network.client.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import network.client.ClientController;

public class LoginGUI {
	private JTextField userText;
	private JTextField passwordText;
	private ClientController cc;
	private JFrame frame;
	
	public LoginGUI(ClientController cc){
		this.cc = cc;
		
		frame = new JFrame("DailyScheduler - login");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}

	private void placeComponents(JPanel panel) {

		panel.setLayout(null);

		JLabel userLabel = new JLabel("Username");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		JButton loginButton = new JButton("Login");
		loginButton.setBounds(10, 80, 80, 25);
		panel.add(loginButton);
		
		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				cc.login(userText.getText(), passwordText.getText());
			}	
		});
	}

	public void close() {
		frame.dispose();
	}
	
	
	
}
