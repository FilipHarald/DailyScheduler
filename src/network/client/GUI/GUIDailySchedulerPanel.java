package network.client.GUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

public class GUIDailySchedulerPanel extends JPanel{
//	private JPanel test = new JPanel(new BorderLayout());
//
//
//	private JPanel pnlInloggning = new JPanel (new GridLayout (2,2));
//
//
//	private JLabel lblName = new JLabel ("Användaramn: ");
//	private JTextField tfName = new JTextField(10);
//
//	private JLabel lblPass = new JLabel ("Lösenord: ");
//	private JTextField tfPass = new JTextField(10);
//
//	private JButton btnSummary = new JButton("Logga in");


public static void main(String[] args){
	new GUIDailySchedulerPanel();
}

	public GUIDailySchedulerPanel() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
					ex.printStackTrace();
				}

				JPanel form = new JPanel(new GridBagLayout());

				JLabel name = new JLabel("Dick Size: ");
				//	        JLabel age = new JLabel("Age: ");

				JTextField field1 = new JTextField(10);
				//	        JTextField field2 = new JTextField(3);

				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridx = 0;
				gbc.gridy = 0;
				gbc.anchor = GridBagConstraints.WEST;

				form.add(name, gbc);
				gbc.gridy++;
				//	                form.add(age, gbc);

				gbc.gridx++;
				gbc.gridy = 0;
				form.add(field1, gbc);
				gbc.gridy++;
				//	                form.add(field2, gbc);
				
				JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.add(form);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
			} 
		});
	}
}
