package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import user.User;


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
			Connection connect = DriverManager.getConnection(host, username, password);
			System.out.println ("It worked");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void sendToDb (){
		Statement st;
		try {
			st = (Statement) connect.createStatement();
			ResultSet srs = st.executeQuery("Select * from table_user");
			
			while (srs.next()){
				User user = new User(null, false);
				user.setName (srs.getString("name"));
				user.setTitle (srs.getString("title"));
				userlist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
				}
		}
	
	
	
	public static void main (String [] args) {
		
		Database db = new Database();
		db.connectionToMysql();
		db.sendToDb();
		
	}
}
