package database;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Caret;


public class DatabasGUI extends JPanel{
	private JPanel labelpanel = new JPanel (new GridLayout(1, 1));
	private JPanel inputpanel = new JPanel (new GridLayout(1, 1));
	
	
	private JTextField tfid = new JTextField ();
	private JTextField tfname = new JTextField ();
	private JTextField tfTitle = new JTextField ();
	
	
	
	private JLabel lblid = new JLabel ("ID:");
	private JLabel lblname = new JLabel ("Name:");
	private JLabel lbltitle = new JLabel ("Title/Beskrivning");
	
	

	
	public DatabasGUI () {

		Font nummer1 = new Font ("Meny", Font.BOLD, 12);
		setLayout (new BorderLayout());
		setPreferredSize (new Dimension(600, 300));
		
		labelpanel.setPreferredSize(new Dimension (100, 0));
		lblid.setFont(nummer1);
		lblname.setFont(nummer1);

		labelpanel.add(lblid);
		labelpanel.add(lblname);
		labelpanel.add(lbltitle);
		
		
		inputpanel.add (tfid);
		inputpanel.add (tfname);
		inputpanel.add(tfTitle);
		
		
		add (labelpanel, BorderLayout.CENTER);
		add (inputpanel, BorderLayout.SOUTH);
	
		

		
	}
	
	public int getid (){
		return Integer.parseInt(tfid.getText());
	}

	public String getName () {
		return tfname.getText();
	}
	
	public String getTitle (){
		return tfTitle.getText();
	}
}

	

