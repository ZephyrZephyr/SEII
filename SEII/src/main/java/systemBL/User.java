package systemBL;

import words.UserType;

public class User {
	private String id;
	private String password;
	private UserType type;
	public User(String id, String password, UserType type) {
		super();
		this.id = id;
		this.password = password;
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	
}
