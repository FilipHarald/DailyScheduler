package entities;

public class User {
	private String name;
        private String ID;
        private boolean isAdmin;

	public User(String name, String ID, boolean isAdmin) {
		this.name = name;
                this.ID = ID;
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
        
        public String getID(){
            return ID;
        }

}
