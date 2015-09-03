package com.epam.libraryManager.entity;

public class Book {
	private String bookID;
	private String bookName;
	private String bookAuthor;
	private int publishingDate;
	private Genre genre;
	
	public String getBookID() {
		return bookID;
	}
	
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getBookAuthor() {
		return bookAuthor;
	}
	
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	public int getPublishingDate() {
		return publishingDate;
	}
	
	public void setPublishingDate(int publishingDate) {
		this.publishingDate = publishingDate;
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

}