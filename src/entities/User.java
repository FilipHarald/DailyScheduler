package entities;

import java.io.Serializable;

/**
 * This class represents a user
 * 
 * @author Filip
 *
 */
public class User implements Serializable{
	private String name;
	private boolean isAdmin;
	private String password;
	private int Id;

	public User(String name, boolean isAdmin, String password, int Id) {
		this.name = name;
		this.isAdmin = isAdmin;
		this.password = password;
		this.Id = Id;			
	}
	
	/**
	 * @return the Id of the User
	 */
	public int getId () {
		return Id;
	}

	/**
	 * @return a boolean
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * @param admin says whether the user should be administrator
	 */
	public void setAdmin(boolean admin) {
		this.isAdmin = admin;
	}

	/**
	 * @return the name of the user
	 */
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	// @Override
	// public String toString() {
	// return name + ",|," + ID + ",|," + isAdmin;
	// }

}
