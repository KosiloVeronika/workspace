package com.epam.libraryManager.entity;

public class User {
	private String userID;
	private String username;
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

	public int getIsAdmin() {
		return admin;
	}

	public void setIsAdmin(int admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return String.format("UserName: %s Password: %d", getUsername(), getIsAdmin());
		
	}
}
