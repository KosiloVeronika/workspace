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

public class SectionDAO implements DataAccessDao {
	private final String GET_SECTION_BY_ID = "SELECT * FROM `section` WHERE id_section = '%d' ";
	private final String GET_ALL_SECTIONS = "SELECT * FROM `section`";

	public ArrayList<Section> getAllSections() throws DaoException {
		ArrayList<Section> sections = new ArrayList<Section>();
		Connection connection = null;
		Statement statement;
		ResultSet resultSet;
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            connection = pool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_SECTIONS);

            while (resultSet.next()) {
                sections.add(new Section(resultSet.getInt("id_section"),resultSet.getString("name")));
            }
            return sections;

        } catch (SQLException | ConnectionPoolException ex) {
            throw new DaoException(ex);
        } finally {
        	pool.freeConnection(connection);
        }
	}
	
	public Section getSectionById(int id) throws DaoException {
		Section section = null;
		Connection connection = null;
		Statement statement;
		ResultSet resultSet;
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
        	String query = String.format(GET_SECTION_BY_ID , id);
            connection = pool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                section = new Section(resultSet.getInt("id_section"), 
                		resultSet.getString("name"));
            }
            return section;

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
