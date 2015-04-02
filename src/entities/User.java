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

	public User(String name, String ID, boolean isAdmin) {
		this.name = name;
		this.ID = ID;
		this.isAdmin = isAdmin;
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

	/**
	 * @return the ID of the user
	 */
	public String getID() {
		return ID;
	}

	// @Override
	// public String toString() {
	// return name + ",|," + ID + ",|," + isAdmin;
	// }

}
