package com.epam.libraryManager.entity;

import java.util.Date;

public class Subscription {
	private int subscriptionID;
	private Statment st;
	private User user;
	private Date wasTaken;
	private Date wasReturned;
	public Subscription() {
	}
	
	public int getSubscriptionID() {
		return subscriptionID;
	}
	
	public void setSubscriptionID(int subscriptionID) {
		this.subscriptionID = subscriptionID;
	}
	
	public Statment getSt() {
		return st;
	}
	
	public void setSt(Statment st) {
		this.st = st;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Date getWasTaken() {
		return wasTaken;
	}
	
	public void setWasTaken(Date wasTaken) {
		this.wasTaken = wasTaken;
	}
	
	public Date getWasReturned() {
		return wasReturned;
	}
	
	public void setWasReturned(Date wasReturned) {
		this.wasReturned = wasReturned;
	}

}
