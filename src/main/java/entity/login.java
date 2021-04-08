package entity;

public class login {
	private String userId;
	private int userPassword;
	
	
	
	public login() {
	}



	public login(String id, int pw) {
		this.userId = id;
		this.userPassword = pw;
	}



	public String getId() {
		return userId;
	}



	public void setId(String id) {
		userId = id;
	}



	public int getPw() {
		return userPassword;
	}



	public void setPw(int pw) {
		userPassword = pw;
	}
	
	
	
}
