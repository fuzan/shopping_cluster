package model;

import com.google.gson.annotations.Expose;

public class User {
	@Expose
	private int id;
	
	@Expose
	private String userName;
	
	@Expose
	private String email;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
}
