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

public class BookDAO implements DataAccessDao {
	private final String GET_BOOK_BY_USER_ID = "SELECT * FROM `book` WHERE id_book = '%d' ";
	private final String GET_BOOK_BY_ID = "SELECT * FROM `book` WHERE id_book = '%d'";
	private final String GET_ALL_BOOKS = "SELECT * FROM `book`";

	@Override
	public ArrayList<Book> getAllBooks() throws DaoException {
		ArrayList<Book> books = new ArrayList<Book>();
		Book book = null;
		Connection connection = null;
		Statement statement;
		ResultSet resultSet;
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            connection = pool.getConnection();
            AuthorDAO ad = new AuthorDAO();
            SectionDAO sd = new SectionDAO();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_BOOKS);
            while (resultSet.next()) {
            	book =  new Book();
            	System.out.print(resultSet.getInt("id_book"));
            	book.setBookID(resultSet.getInt("id_book"));//������ ����� SuppressWarnings("null")

            	System.out.println(resultSet.getString("name"));
            	book.setBookName(resultSet.getString("name"));
            	System.out.println(resultSet.getInt("id_author_fk"));
            	book.setBookAuthor(ad.getAuthorById(resultSet.getInt("id_author_fk")));
            	System.out.println(resultSet.getInt("is_avalible"));
            	book.setIsAvalible(resultSet.getInt("is_avalible"));
            	System.out.println(resultSet.getInt("number_of_pages"));
            	book.setNumberOfPages(resultSet.getInt("number_of_pages"));
            	System.out.println(resultSet.getInt("publication_date"));
            	book.setPublicationDate(resultSet.getInt("publication_date"));
            	System.out.println(resultSet.getInt("id_section_fk"));
            	book.setSection(sd.getSectionById(resultSet.getInt("id_section_fk")));
                books.add(book);
                System.out.println(book.toString());
            }
        	statement.close();
            return books;

        } catch (SQLException | ConnectionPoolException ex) {
            throw new DaoException(ex);
        } finally {
        	pool.freeConnection(connection);
        }
	}
	
	public Book getBookById(int id) throws DaoException {
		Book book = null;
		Connection connection = null;
		Statement statement;
		ResultSet resultSet;
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            connection = pool.getConnection();
            String query = String.format(GET_BOOK_BY_ID , id);
            AuthorDAO ad = new AuthorDAO();
            SectionDAO sd = new SectionDAO();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
            	book = new Book();
            	book.setBookID(resultSet.getInt("id_book"));//������ ����� SuppressWarnings("null")
            	book.setBookName(resultSet.getString("name"));
            	book.setBookAuthor(ad.getAuthorById(resultSet.getInt("id_author_fk")));
            	book.setIsAvalible(resultSet.getInt("is_avalible"));
            	book.setNumberOfPages(resultSet.getInt("number_of_pages"));
            	book.setPublicationDate(resultSet.getInt("publication_date"));
            	book.setSection(sd.getSectionById(resultSet.getInt("id_section_fk")));

            }
        	statement.close();
            return book;

        } catch (SQLException | ConnectionPoolException ex) {
            throw new DaoException(ex);
        } finally {
        	pool.freeConnection(connection);
        }
	}
	
	@Override
	public ArrayList<Book> getBooksByUserId(int id) throws DaoException {
		ArrayList<Book> books = new ArrayList<Book>();
		Book book = null;
		Connection connection = null;
		Statement statement;
		ResultSet resultSet;
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            connection = pool.getConnection();
            String query = String.format(GET_BOOK_BY_USER_ID , id);
            AuthorDAO ad = new AuthorDAO();
            SectionDAO sd = new SectionDAO();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
            	book = new Book();
            	book.setBookID(resultSet.getInt("id_book"));//������ ����� SuppressWarnings("null")
            	book.setBookName(resultSet.getString("name"));
            	book.setBookAuthor(ad.getAuthorById(resultSet.getInt("id_author")));
            	book.setIsAvalible(resultSet.getInt("is_avalible"));
            	book.setNumberOfPages(resultSet.getInt("number_of_pages"));
            	book.setPublicationDate(resultSet.getInt("publication_date"));
            	book.setSection(sd.getSectionById(resultSet.getInt("id_section_fk")));
                books.add(book);
            }
        	statement.close();
            return books;

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
