package com.epam.libraryManager.entity;

public class Order {
	private int orderID;
	private User user;
	private Book book;
	private Statment st;
	public Order() {
	}
	
	public int getOrderID() {
		return orderID;
	}
	
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public Statment getSt() {
		return st;
	}
	
	public void setSt(Statment st) {
		this.st = st;
	}
}
