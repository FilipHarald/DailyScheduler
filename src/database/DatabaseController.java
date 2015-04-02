package database;

import entities.User;

public class DatabaseController {
private Database database;
private User user;

	public void checkUser (){
		if (user.getName().isEmpty()){
			System.out.println("User does not exist");
		}
		
	}
	
	public void checkPassword (){
		
	}
	
}
