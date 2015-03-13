package network.client.GUI;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIDailySchedulerPanel extends JPanel{
//	private JPanel pnlCenter = new JPanel (new BorderLayout());
//	private JPanel pnlSouth = new JPanel (new BorderLayout());
	private JPanel pnlCenterCenter = new JPanel (new BorderLayout());
	

	private JPanel pnlInloggning = new JPanel (new GridLayout (2,2));
	
	
	private JLabel lblName = new JLabel ("Användaramn: ");
	private JTextField tfName = new JTextField();
	
	private JLabel lblPass = new JLabel ("Lösenord: ");
	private JTextField tfPass = new JTextField();
	
	private JButton btnSummary = new JButton("Logga in");
	
	
	
	public GUIDailySchedulerPanel() {
		setPreferredSize(new Dimension (250,200));
		setLayout(new BorderLayout());
		
		
		
		
		pnlCenterCenter.setBorder( BorderFactory.createTitledBorder( "Inloggning" ) );
		pnlCenterCenter.add(pnlInloggning, BorderLayout.CENTER );
		pnlCenterCenter.add(btnSummary, BorderLayout.SOUTH);
		
		lblPass.setPreferredSize(new Dimension(50,50));
		tfPass.setPreferredSize(new Dimension(50,50));
		lblName.setPreferredSize(new Dimension(50,50));
		tfName.setPreferredSize(new Dimension(50,50));
		
		
		pnlInloggning.add(lblName);
		pnlInloggning.add(tfName);
		pnlInloggning.add(lblPass);
		pnlInloggning.add(tfPass);
		
		add(pnlCenterCenter,BorderLayout.CENTER);
		
		
		
	} 

}
