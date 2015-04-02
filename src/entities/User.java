package entities;

/**
 * This class represents a user
 * 
 * @author Filip
 *
 */
public class User {
	private String name;
	private String ID;
	private boolean isAdmin;
	private int Id;

	public User(String name, boolean isAdmin, int Id) {
		this.name = name;
		this.ID = ID;
		this.isAdmin = isAdmin;
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
		this.isAdmin = isAdmin;
	}

	/**
	 * @return the name of the user
	 */
	public String getName() {
		return name;
	}

	// @Override
	// public String toString() {
	// return name + ",|," + ID + ",|," + isAdmin;
	// }

}
