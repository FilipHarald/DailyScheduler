package database;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import com.mysql.jdbc.Statement;

import entities.Team;
import entities.User;
import entities.Task;

public class Database {

	private static Connection connect;
	private User user;
	private Team team;
	private Task task;
	private static DatabasGUI gui = new DatabasGUI();
	
	//Start connection to localhost
	public void connectionToMysql () throws ClassNotFoundException{
		String host = "jdbc:mysql://localhost/test";
		String username = "root", password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(host, username, password);
			System.out.println ("Connected to database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Send data to table user
	public void sendToTableUser (int idtable_user, String name, String title) throws SQLException {
		PreparedStatement state = connect.prepareStatement("INSERT INTO table_user (idtable_user, name, title) values (?,?,?)");
		
		state.setInt(1, idtable_user);
		state.setString(2, user.getName());
		state.setString(3, title);
		
		state.executeUpdate();
		state.close();
		connect.close();
		System.out.println("Saved to table user");
		
	}
	
	//Send data to table task
	public void sendToTableTask (int idtable_task, String name, String text) throws SQLException{
		PreparedStatement state = connect.prepareStatement("INSERT INTO table_task (idtable_task, name, text) values (?,?,?)");
		

		state.setInt(1, task.getId());
//		state.setString(2, task.getAuthor());
		state.setString(3, task.getDescription());
	
		state.executeUpdate();
		state.close();
		connect.close();
		
		System.out.println ("Saved to table task");
		
	}
	
	
	//Send data to table teams
	public void sendToTableTeams (String idtable_teams, String name) throws SQLException{
		PreparedStatement state = connect.prepareStatement("INSERT INTO table_teams (idtable_teams, name) values (?,?)");
		state.setString(1, gui.getid());
		state.setString(2, gui.getName());
		
		state.executeUpdate();
		state.close();
		connect.close();
		
		System.out.println ("Saved to table teams");
		
	}
	
	//Get users table
	public static ResultSet getUsersResult (Connection connect1, String sql) throws Exception {
		Statement state = (Statement) connect1.createStatement(java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.TYPE_FORWARD_ONLY);
		return state.executeQuery(sql);
		
	}
	
	public static ResultSet getUsers (Connection connect2) throws Exception{
		return getUsersResult (connect2, "select * from table_user");
		
	}
	
	//Get team table
	public static ResultSet getTeamResult (Connection connection, String sql) throws SQLException{
		Statement state = (Statement) connection.createStatement(java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.TYPE_FORWARD_ONLY);
		return state.executeQuery(sql);
	}
	
	public static ResultSet getTeams (Connection connection) throws SQLException {
		return getTeamResult(connection, "select * from table_teams");
		
	}
	
	//Get task table
	public static ResultSet getTaskResult (Connection connection, String sql) throws SQLException {
		Statement state = (Statement) connection.createStatement(java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.TYPE_FORWARD_ONLY);
		return state.executeQuery(sql);
	}
	
	public static ResultSet getTask (Connection connection) throws SQLException{
		return getTeamResult(connection, "select * from table_task");
	}
	
	//Shows the information stored in databases 
	public void ShowResult () throws Exception{
		
		JOptionPane.showMessageDialog(null, "User"+ "\n"+ "Team"+ "\n"+ "Task");
		String pane = JOptionPane.showInputDialog("");
		
		if (pane.equals("User")){
		ResultSet rs = getUsers(connect);
		while (rs.next()){
			System.out.println( rs.getString(1)+ ", "+ rs.getString(2)+ ", "+ rs.getString(3));
		
		}
		}else if (pane.equals("Team")){
		ResultSet rs2 = getTeams (connect);
		while (rs2.next()){	
			System.out.println(rs2.getString(1)+ ", "+ rs2.getString(2));
		}

		} else if (pane.equals("Task")){
			ResultSet rs3 = getTask(connect);
			while (rs3.next()){
				System.out.println (rs3.getString(1)+ ", "+ rs3.getString(2)+ ", "+ rs3.getString(3));
			}
			
		}
	}

	public static void main (String [] args) throws Exception {
		Database db = new Database();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(gui);
			frame.pack();
			frame.setVisible(true);
			}
			});
		
		try {
			db.connectionToMysql();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

//		try {
//		db.sendToTableUser(0, "", "");
//		db.sendToTableTask(0, "", "");
//		db.sendToTableTeams("", "");
//		
//	} catch (SQLException e) {
//		e.printStackTrace();
		
		db.ShowResult();
		

		

	}
		
}



