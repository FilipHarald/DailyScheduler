package database;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import entities.Team;
import entities.User;
import entities.Task;

public class Database {

	private static Connection connect;
	private User user;
	private Team team;
	private Task task;
	
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
		
		state.setInt(1, user.getID());
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
		state.setString(2, task.getAuthor());
		state.setString(3, task.getDescription());
	
		state.executeUpdate();
		state.close();
		connect.close();
		
		System.out.println ("Saved to table task");
		
	}
	
	//Send to table teams
	public void sendToTableTeams (int idtable_teams, String name) throws SQLException{
		PreparedStatement state = connect.prepareStatement("INSERT INTO table_teams (idtable_teams, name) values (?,?)");
		
		state.setInt(1, team.getID());
		state.setString(2, team.getTeamName());
		
		state.executeUpdate();
		state.close();
		connect.close();
		
		System.out.println ("Saved to table teams");
		
	}
	
	public static ResultSet getUsersResult (Connection connect1, String sql) throws Exception {
		Statement state = (Statement) connect1.createStatement(java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.TYPE_FORWARD_ONLY);
		return state.executeQuery(sql);
		
	}
	
	public static ResultSet getUsers (Connection connect2) throws Exception{
		return getUsersResult (connect2, "select * from table_user");
		
	}
	
	public static ResultSet getTeamResult (Connection connection, String sql) throws SQLException{
		Statement state = (Statement) connection.createStatement(java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.TYPE_FORWARD_ONLY);
		return state.executeQuery(sql);
	}
	
	public static ResultSet getTeams (Connection connection) throws SQLException {
		return getTeamResult(connection, "select * from table_teams");
		
	}
	
	public static void ComboList (){
		String [] list1 = {"User", "Team"};
		JComboBox list = new JComboBox (list1);
		list.setSelectedItem(2);
		list.addActionListener(list);
	}
	public static void main (String [] args) throws Exception {
		Database db = new Database();
		try {
			db.connectionToMysql();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	
		try {
			db.sendToTableUser(0, "", "");
			db.sendToTableTask(0, "", "");
			db.sendToTableTeams(0, "");
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		
		ResultSet rs = getUsers(connect);
		while (rs.next()){
			JOptionPane.showMessageDialog(null, rs.getString(1)+ "\n"+ rs.getString(2)+ "\n"+ rs.getString(3));
		
		}
	
		ResultSet rs2 = getTeams (connect);
		while (rs2.next()){	
			JOptionPane.showMessageDialog(null, rs2.getString(1)+ "\n"+ rs2.getString(2));
		}
		
		
		}

	}
}



