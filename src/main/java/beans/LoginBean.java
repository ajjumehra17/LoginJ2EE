package beans;

import java.io.Serializable;

import dao.StudentDAO;

public class LoginBean implements Serializable{
 	private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private int id;
    
    public LoginBean() {
	   
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean login() {
		return new StudentDAO().loginverify(this);
	}
    
 	
}
