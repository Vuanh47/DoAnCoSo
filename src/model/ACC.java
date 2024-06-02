package model;

public class ACC {
	String user;
	String password;
	public ACC(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}
	public ACC() {
		// TODO Auto-generated constructor stub
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static ACC getACC() {
		return new ACC();
	}
	
}
