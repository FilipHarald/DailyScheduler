package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {

	public static void connection () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static void connectionToMysql (){
		connection();
		String host = "jdbc:mysql://localhost/test";
		String username = "root";
		String password = "";
		try {
			Connection connect = DriverManager.getConnection(host, username, password);
			System.out.println ("It worked");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main (String [] args) {
		connectionToMysql();
	}
}
