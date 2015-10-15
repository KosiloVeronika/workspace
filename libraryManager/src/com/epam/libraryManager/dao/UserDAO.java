package com.epam.libraryManager.dao;

import java.util.ArrayList;

import com.epam.libraryManager.entity.Author;
import com.epam.libraryManager.entity.Book;
import com.epam.libraryManager.entity.Order;
import com.epam.libraryManager.entity.Section;
import com.epam.libraryManager.entity.Statment;
import com.epam.libraryManager.entity.User;

public class UserDAO implements DataAccessDao {

	@Override
	public User getUserFromSource(String username, String password) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean checkUser(String mail, String username, String password) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<Book> getBooksByUserId(int id) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<Book> getAllBooks() throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<Section> getAllSections() throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Section getSectionById(int id) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<Author> getAllAuthors() throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Author getAuthorById(int id) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<Order> getAllOrders() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Order> getOrdersByUserId(int i) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addOrder(int user_id, int book_id, Statment st) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

}
