package com.epam.libraryManager.entity;

public class User {
	private String userID;
	private String username;
	private String email;
	private String password;
	private int admin;
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsAdmin() {
		return admin;
	}

	public void setIsAdmin(int admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return String.format("UserName: %s Password: %s", getUsername(), getPassword());
		
	}
}
