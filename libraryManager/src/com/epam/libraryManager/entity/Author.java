package com.epam.libraryManager.entity;

public class Author {
	private int id;
	private String name;
	private String surname;
	private String secondName;
	public Author(int id, String name, String surname, String secondName) {
		setId(id);
		setName(name);
		setSurname(surname);
		setSecondName(secondName);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

}
