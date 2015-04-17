package database;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import entities.User;

public class TestProgram extends JPanel implements ActionListener  {
	
	private static DatabaseController db = new DatabaseController();
	private DatabasGUI gui = new DatabasGUI();
	private JButton btnsave = new JButton ("Save");
	private JButton btnchoose = new JButton ("Choose");
	
	public TestProgram (){
		setLayout (new BorderLayout());
		setPreferredSize (new Dimension(600, 300));
		
		btnsave.addActionListener(this);
		btnchoose.addActionListener(this);
		
		add (gui, BorderLayout.CENTER);
		add (btnsave, BorderLayout.SOUTH);
		add (btnchoose, BorderLayout.NORTH);
	}
	public static void main (String [] args) throws Exception {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add (new TestProgram());
			frame.pack();
			frame.setVisible(true);
			}
			});
		
		try {
			db.ShowResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent e1) {
			e1.getSource();
			try {
				db.saveEntity(new User("TestaKarlsson", false, "1234", 0));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
}
	

	

