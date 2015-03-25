package entities;

public class User {
	private String name;
        private String username;
        private boolean isAdmin;

	public User(String name, String username, boolean isAdmin) {
		this.name = name;
                this.username = username;
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
        
        public String getUsername(){
            return username;
        }

}
