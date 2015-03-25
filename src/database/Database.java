package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import entities.User;


public class Database {

	Connection connect;
	ArrayList <User> userlist = new ArrayList <User>();
	public static void connection () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void connectionToMysql (){
		connection();
		String host = "jdbc:mysql://localhost/test";
		String username = "root", password = "";
		try {
			connect = DriverManager.getConnection(host, username, password);
			System.out.println ("It worked");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void sendToTableUser (int idtable_user, String name, String title) throws SQLException {
		PreparedStatement state = connect.prepareStatement("INSERT INTO table_user (idtable_user, name, title) values (?,?,?)");
		
		state.setInt(1, idtable_user);
		state.setString(2, name);
		state.setString(3, title);
		state.executeUpdate();
		state.close();
		connect.close();
		System.out.println("Saved to user");
		
	}
	
	public void sendToTableTask (int idtable_task, String name, String text) throws SQLException{
		PreparedStatement state = connect.prepareStatement("INSERT INTO table_task (idtable_task, name, text) values (?,?,?)");
		
		state.setInt(1, idtable_task);
		state.setString(2, name);
		state.setString(3, text);
		state.executeUpdate();
		state.close();
		connect.close();
		
		System.out.println ("Saved to task");
		
	}
	

	
	
	
	public static void main (String [] args) {

		Database db = new Database();
		db.connectionToMysql();
		try {
//			db.sendToTableUser(6,"Klein", "Admin");
			db.sendToTableTask(1, "Plocka mjölk", "Ta en pall och ta en vagn med mellan mjölk");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
