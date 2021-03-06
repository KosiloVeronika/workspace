package com.epam.libraryManager.entity;

public class Book {
	private int bookID;
	private String bookName;
	private Author bookAuthor;
	private int publicationDate;
	private Section section;
	private int isAvalible;
	private int numberOfPages;
	public Book(){
		
	}
	public Book(int bookID, String bookName, Author bookAuthor, int publicationDate, Section section, int isAvalible,
			int numberOfPages) {
		setBookID(bookID);
		setBookName(bookName);
		setBookAuthor(bookAuthor);
		setPublicationDate(publicationDate);
		setSection(section);
		setIsAvalible(isAvalible);
		setNumberOfPages(numberOfPages);
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Author getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(Author bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public int getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(int publicationDate) {
		this.publicationDate = publicationDate;
	}
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	public int getIsAvalible() {
		return isAvalible;
	}
	public void setIsAvalible(int isAvalible) {
		this.isAvalible = isAvalible;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	


}
