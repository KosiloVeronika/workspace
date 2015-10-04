package com.epam.libraryManager.entity;

public class User {
	private String userID;
	private String username;
	private String email;
	private int usertype;
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}	
	
	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int i) {
		this.usertype = i;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("UserName: %s Password: %s", getUsername(), getUsertype());
		
	}
}
