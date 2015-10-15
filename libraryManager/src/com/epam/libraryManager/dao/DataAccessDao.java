package com.epam.libraryManager.dao;

import java.util.ArrayList;

import com.epam.libraryManager.entity.Author;
import com.epam.libraryManager.entity.Book;
import com.epam.libraryManager.entity.Order;
import com.epam.libraryManager.entity.Section;
import com.epam.libraryManager.entity.Statment;
import com.epam.libraryManager.entity.User;

public interface DataAccessDao {
	
	User getUserFromSource(String username, String password) throws DaoException;
	boolean checkUser(String mail, String username, String password) throws DaoException;
	
	ArrayList<Book> getBooksByUserId(int id) throws DaoException;
	ArrayList<Book> getAllBooks() throws DaoException;
	
	ArrayList<Section> getAllSections() throws DaoException;
	Section getSectionById(int id) throws DaoException;
	
	ArrayList<Author> getAllAuthors() throws DaoException;
	Author getAuthorById(int id) throws DaoException;
	
	ArrayList<Order> getAllOrders() throws DaoException;
	ArrayList<Order> getOrdersByUserId(int i) throws DaoException;
	boolean addOrder(int user_id, int book_id, Statment st) throws DaoException;
}
