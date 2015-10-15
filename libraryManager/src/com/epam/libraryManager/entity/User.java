package com.epam.libraryManager.entity;

public class User {
	private int userID;
	private String username;
	private String email;
	private int usertype;
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
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
