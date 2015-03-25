package network.client.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GUIDailySchedulerPanel extends JPanel {

	public JPanel form = new JPanel(new GridBagLayout());

	public JLabel name = new JLabel("Användarnamn: ");
	
	public JLabel pass = new JLabel("Lösenord");

	public JTextField field1 = new JTextField(10);

	JPasswordField field2 = new JPasswordField(15);

	public JButton logIn = new JButton("Logga in");

	public GridBagConstraints gbc = new GridBagConstraints();


	public GUIDailySchedulerPanel() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException ex) {
					ex.printStackTrace();
				}

				gbc.gridx = 0;
				gbc.gridy = 0;
				gbc.anchor = GridBagConstraints.WEST;

				form.add(name, gbc);
				
				gbc.gridy++;
				form.add(pass,gbc);
				gbc.gridy++;
				form.add(logIn, gbc);

				gbc.gridx++;
				gbc.gridy = 0;
				form.add(field1, gbc);
				gbc.gridy++;
				form.add(field2,gbc);
				gbc.gridy++;
				form.add(logIn, gbc);

				JFrame frame = new JFrame("Testing");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.add(form);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				loginListener();

				//				public void loginListener(){


			}

		});



	}
	public void loginListener(){
		logIn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				String puname = field1.getText();
				String ppaswd = field2.getText();
				if(puname.equals("test")&& ppaswd.equals("12345")) {
					GUIDailySchedulerApp regFace =new GUIDailySchedulerApp();
					regFace.setVisible(true);
					//					dispose();
				} else {

					JOptionPane.showMessageDialog(null,"Wrong Password / Username");
					field1.setText("");
					field2.setText("");
					field1.requestFocus();

				}


			}

			//			private void dispose() {
			//				// TODO Auto-generated method stub
			//				
			//			}
		});
	}

}
