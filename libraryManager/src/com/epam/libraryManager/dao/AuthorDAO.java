package com.epam.libraryManager.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.epam.libraryManager.connectionpool.ConnectionPool;
import com.epam.libraryManager.connectionpool.ConnectionPoolException;
import com.epam.libraryManager.entity.Author;
import com.epam.libraryManager.entity.Book;
import com.epam.libraryManager.entity.Order;
import com.epam.libraryManager.entity.Section;
import com.epam.libraryManager.entity.Statment;
import com.epam.libraryManager.entity.User;

public class AuthorDAO implements DataAccessDao {

	private final String GET_AUTHOR_BY_ID = "SELECT * FROM `author` WHERE id_author = '%d' ";
	private final String GET_ALL_AUTHORS = "SELECT * FROM `author`";

	@SuppressWarnings("null")
	public ArrayList<Author> getAllAuthors() throws DaoException {
		ArrayList<Author> authors = new ArrayList<Author>();
		Author author = null;
		Connection connection = null;
		Statement statement;
		ResultSet resultSet;
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            connection = pool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_AUTHORS);
            while (resultSet.next()) {
            	author.setId(resultSet.getInt("id_author"));//просил здесь SuppressWarnings("null")
            	author.setName(resultSet.getString("name"));
            	author.setSecondName(resultSet.getString("second_name"));
            	author.setSurname(resultSet.getString("thurname"));
                authors.add(author);
            }
        	statement.close();
            return authors;

        } catch (SQLException | ConnectionPoolException ex) {
            throw new DaoException(ex);
        } finally {
        	pool.freeConnection(connection);
        }
	}
	
	public Author getAuthorById(int id) throws DaoException {
		Author author = null;
		Connection connection = null;
		Statement statement;
		ResultSet resultSet;
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
        	String query = String.format(GET_AUTHOR_BY_ID , id);
            connection = pool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

        	System.out.print("lolo");
            while (resultSet.next()) {
                author = new Author(resultSet.getInt("id_author"), resultSet.getString("name"),
                		resultSet.getString("thurname"), resultSet.getString("second_name"));
            }
        	statement.close();
            return author;

        } catch (SQLException | ConnectionPoolException ex) {
            throw new DaoException(ex);
        } finally {
        	pool.freeConnection(connection);
        }
	}

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
