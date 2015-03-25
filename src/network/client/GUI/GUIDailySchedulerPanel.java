package network.client.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class GUIDailySchedulerPanel extends JPanel {

	public JPanel form = new JPanel(new GridBagLayout());

	public JLabel name = new JLabel("Användarnamn: ");

	public JTextField field1 = new JTextField(10);

	public JButton logIn = new JButton("Logga in");

	public GridBagConstraints gbc = new GridBagConstraints();

	public static void main(String[] args) {
		new GUIDailySchedulerPanel();
	}

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
				form.add(logIn, gbc);

				gbc.gridx++;
				gbc.gridy = 0;
				form.add(field1, gbc);
				gbc.gridy++;
				form.add(logIn, gbc);

				JFrame frame = new JFrame("Testing");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.add(form);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

				logIn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String res = field1.getText() + "\n";
						System.out.println(res);
					}
					
				});
			}

		});
	


	}

}
