package user;

public class User {
	private boolean isAdmin;
	private String name;

	public User(String name, boolean isAdmin) {
		this.name = name;
		this.isAdmin = isAdmin;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getName() {
		return name;
	}

}
