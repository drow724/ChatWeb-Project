package entity;

public class login {
	private String Id;
	private int Pw;
	
	
	
	public login() {
	}



	public login(String id, int pw) {
		this.Id = id;
		this.Pw = pw;
	}



	public String getId() {
		return Id;
	}



	public void setId(String id) {
		Id = id;
	}



	public int getPw() {
		return Pw;
	}



	public void setPw(int pw) {
		Pw = pw;
	}
	
	
	
}
