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


public class DatabasGUI extends JPanel implements ActionListener {

	private Connection connect;
	private JPanel labelpanel = new JPanel (new GridLayout(1, 1));
	private JPanel inputpanel = new JPanel (new GridLayout(1, 1));
	private Database data;
	
	private JTextField tfid = new JTextField ();
	private JTextField tfname = new JTextField ();
	
	private JLabel lblid = new JLabel ("ID:");
	private JLabel lblname = new JLabel ("Name:");
	private JButton btnsave = new JButton ("Save");
	public DatabasGUI () {
		Font nummer1 = new Font ("Meny", Font.BOLD, 12);
		setLayout (new BorderLayout());
		setPreferredSize (new Dimension(600, 300));
		
		labelpanel.setPreferredSize(new Dimension (100, 0));
		lblid.setFont(nummer1);
		lblname.setFont(nummer1);
		
		labelpanel.add(lblid);
		labelpanel.add(lblname);
		
		inputpanel.add (tfid);
		inputpanel.add (tfname);
		
		add (labelpanel, BorderLayout.CENTER);
		add (inputpanel, BorderLayout.SOUTH);
		add (btnsave, BorderLayout.EAST);
	}
	
	public String getid (){
		return tfid.getText();
	}

	public String getName (String name) {
		return tfname.getText();
	}

		public void actionPerformed (ActionEvent e){
				
			try {
				data.sendToTableTeams(getid(), getName());
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}


		
	}
	

