package com.epam.libraryManager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.epam.libraryManager.connectionpool.ConnectionPool;
import com.epam.libraryManager.connectionpool.ConnectionPoolException;
import com.epam.libraryManager.entity.Book;
import com.epam.libraryManager.entity.Library;
import com.epam.libraryManager.entity.User;

public class DatabaseDao implements DataAccessDao {
	private final static String QUERY = "SELECT * FROM `user`";
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    @Override
    public Library getLibraryFromSource(Object ... args) throws DatabaseException {
        try {
            ConnectionPool pool = ConnectionPool.getInstance();
            connection = pool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(QUERY);
            
            Library library = new Library();
            ArrayList<Book> books = (ArrayList<Book>) library.getRoom();

            while (resultSet.next()) {
                Book book = new Book();
                
                book.setBookID(resultSet.getString("ID"));
                book.setBookAuthor(resultSet.getString("bookAuthor"));
                //book.setGenre((Genre)resultSet.getString("genre"));
                book.setBookName(resultSet.getString("bookName"));
                book.setPublishingDate(resultSet.getInt("publishingDate"));

                books.add(book);
            }
            pool.freeConnection(connection);
            pool.closeConnections();
            return library;

        } catch (SQLException | ConnectionPoolException ex) {
            throw new DatabaseException(ex);
        }
        
    }
	@Override
	public User getUserFromSource(String username) throws DataAccessException {
        try {
        	String query = String.format("SELECT * FROM `user` WHERE username = '%s' ", username);
            ConnectionPool pool = ConnectionPool.getInstance();
            connection = pool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            User user = new User();
            while (resultSet.next()) {
            	
                user.setEmail(resultSet.getString("mail"));
                user.setPassword(resultSet.getString("password"));
                user.setUsername(resultSet.getString("username"));
                user.setIsAdmin(resultSet.getInt("admin"));
                System.out.println(user.toString());
                
               // books.add(user);
            }
            pool.freeConnection(connection);
            pool.closeConnections();
            return user;

        } catch (SQLException | ConnectionPoolException ex) {
            throw new DatabaseException(ex);
        }
        
	}
	
	@Override
	public boolean checkUser(String mail, String username, String password) throws DatabaseException {
		try {
			String query = String.format("SELECT * FROM `user` WHERE mail = '%s' ", mail);
            ConnectionPool pool = ConnectionPool.getInstance();
            connection = pool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            //System.out.println(resultSet.next());
            if (!resultSet.next()) {
            	PreparedStatement ps = connection.prepareStatement("INSERT INTO user(mail, password,admin, username) VALUES(?,?,?,?)");
            	ps.setString(1, mail);
            	ps.setString(2, password);
            	ps.setInt(3, 0);
            	ps.setString(4, username);
            	ps.executeUpdate();
            	return true;
            } 
            pool.freeConnection(connection);
            pool.closeConnections();
            return false;

        } catch (SQLException | ConnectionPoolException ex) {
            throw new DatabaseException(ex);
        }
	}
    
}