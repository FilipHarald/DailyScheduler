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
	private DatabasGUI gui = new DatabasGUI();
	
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
		state.setString(2, name);
		state.setString(3, title);
		
		state.executeUpdate();
		state.close();
		connect.close();
		System.out.println("Saved to table user");
		
	}
	
	//Send data to table task
	public void sendToTableTask (int idtable_task, String name, String text) throws SQLException{
		PreparedStatement state = connect.prepareStatement("INSERT INTO table_task (idtable_task, name, text) values (?,?,?)");
		

		state.setInt(1, idtable_task);
		state.setString(2, name);
		state.setString(3, text);
	
		state.executeUpdate();
		state.close();
		connect.close();
		
		System.out.println ("Saved to table task");
		
	}
	
	//Send data to table teams
	public void sendToTableTeams (int idtable_teams, String name) throws SQLException{
		PreparedStatement state = connect.prepareStatement("Insert into table_teams (idtable_teams, name) values (?,?)");
		
		state.setInt(1, idtable_teams);
		state.setString(2, name);
		state.executeUpdate();
		state.close();
		connect.close();
		
	}
	
	//Get users table
	public static ResultSet getUsersResult (Connection connect1, String sql) throws Exception {
		Statement state = (Statement) connect1.createStatement(java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.TYPE_FORWARD_ONLY);
		return state.executeQuery(sql);
		
	}
	
	public static ResultSet getUsers (Connection connect2, String tableName) throws Exception{
		String sqlStatement = String.format("select * from %s", tableName);
		return getUsersResult (connect2, sqlStatement );
		
	}
	
	//Get team table
	public static ResultSet getTeamResult (Connection connection, String sql) throws SQLException{
		Statement state = (Statement) connection.createStatement(java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.TYPE_FORWARD_ONLY);
		return state.executeQuery(sql);
	}
	
	public static ResultSet getTeams (Connection connection) throws SQLException {
		return getTeamResult(connection, "select * from Teams");
		
	}
	
	//Get task table
	public static ResultSet getTaskResult (Connection connection, String sql) throws SQLException {
		Statement state = (Statement) connection.createStatement(java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.TYPE_FORWARD_ONLY);
		return state.executeQuery(sql);
	}
	
	public static ResultSet getTask (Connection connection) throws SQLException{
		return getTeamResult(connection, "select * from Task");
	}
	
	//Shows the information stored in databases 
	public void ShowResult () throws Exception{
		JOptionPane.showMessageDialog(null, "Visa information från databas");
		JOptionPane.showMessageDialog(null, "User"+ "\n"+ "Team"+ "\n"+ "Task");
		String pane = JOptionPane.showInputDialog("");

		
		ResultSet rs = getUsers(connect, pane);
		while (rs.next()){
			
			System.out.println( rs.getString(1)+ ", "+ rs.getString(2)+ ", "+ rs.getString(3));
		
		}
//		if (pane.equals("User")){
//		ResultSet rs = getUsers(connect, "User");
//		while (rs.next()){
//			System.out.println( rs.getString(1)+ ", "+ rs.getString(2)+ ", "+ rs.getString(3));
//		
//		}
//		}else if (pane.equals("Team")){
//		ResultSet rs2 = getTeams (connect);
//		while (rs2.next()){	
//			System.out.println(rs2.getString(1)+ ", "+ rs2.getString(2));
//		}
//
//		} else if (pane.equals("Task")){
//			ResultSet rs3 = getTask(connect);
//			while (rs3.next()){
//				System.out.println (rs3.getString(1)+ ", "+ rs3.getString(2)+ ", "+ rs3.getString(3));
//			}
//			
//		}
	}


	public void SaveResult (){
		
		JOptionPane.showMessageDialog(null, "Spara till databas");
		JOptionPane.showMessageDialog(null, "User"+ "\n"+ "Team"+ "\n"+ "Task");
		String pane = JOptionPane.showInputDialog("");
		
		if (pane.equals("User")){
			try {
				sendToTableUser(gui.getid(), gui.getName(), gui.getTitle());
				} catch (SQLException e) {
				e.printStackTrace();
				}
		} else if (pane.equals("Team")){
			try {
				sendToTableTeams (gui.getid(), gui.getName());
			} catch (SQLException e){
				e.printStackTrace();
			}
			
		}else if (pane.equals("Task")){
			try {
				sendToTableTask (gui.getid(), gui.getName(), gui.getTitle());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	
	}

	}





