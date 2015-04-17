package database;

import java.sql.SQLException;

import entities.User;

public class Testtest {
	public static void main (String [] args){
		DatabaseController db = new DatabaseController();
		try {
			User user = (User) db.getEntity("User", 5);
			
			System.out.println(user.getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
