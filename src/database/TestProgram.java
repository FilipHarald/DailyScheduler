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

public class TestProgram extends JPanel implements ActionListener  {
	
	private Database db  = new Database();
	private DatabasGUI gui = new DatabasGUI();
	private JButton btnsave = new JButton ("Save");
	
	public TestProgram (){
		setLayout (new BorderLayout());
		setPreferredSize (new Dimension(600, 300));
		btnsave.addActionListener(this);
		
		add (gui, BorderLayout.CENTER);
		add (btnsave, BorderLayout.SOUTH);
	}
	public static void main (String [] args) throws Exception {
		Database db  = new Database();
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
			db.connectionToMysql();
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			db.ShowResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

//		try {
//		db.sendToTableUser(0, "", "");
//		db.sendToTableTask(0, "", "");
		
//		
//		
//		} catch (SQLException e1) {
//		e1.printStackTrace();	
//	}
	}

	public void actionPerformed(ActionEvent e) {
		try {
			db.sendToTableTeams(gui.getid(), gui.getName());
			JOptionPane.showMessageDialog(null, "Data stored");
		} catch (Exception e1){
			e1.printStackTrace();
		}
		
	}

	
}
