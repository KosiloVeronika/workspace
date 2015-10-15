package com.epam.libraryManager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
import com.epam.libraryManager.hashPassword.HashPassword;

public class DatabaseDao implements DataAccessDao {
	private HashPassword hash = new HashPassword();
	private final String CHECK_USER_BY_USERNAME = "SELECT * FROM `user` WHERE login = '%s' ";
	private final String CHECK_USER_BY_MAIL = "SELECT * FROM `user` WHERE `user`.`e-mail` = '%s' ";
	private final String REGISTRATION_QUERY = "INSERT INTO user(`login`,`password` ,`id_user_type_fk`, `salt`, `e-mail`) VALUES(?,?,?,?,?)";
   
	@Override
	public User getUserFromSource(String username, String password) throws DaoException {
		Connection connection = null;
		Statement statement;
		ResultSet resultSet;
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
        	String query = String.format(CHECK_USER_BY_USERNAME , username);
            connection = pool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            User user = null;
            while (resultSet.next()) {
                String hashPassword = resultSet.getString("password");
                byte[] salt = resultSet.getString("salt").getBytes();
                if(hash.hashPasswordWithSalt(password, salt).equals(hashPassword)) {
                	user = new User();
                	user.setUsername(resultSet.getString("login"));
                    user.setUsertype(resultSet.getInt("id_user_type_fk"));
                    user.setUserID(resultSet.getInt("id_user"));
                }
            }
            return user;

        } catch (SQLException | ConnectionPoolException ex) {
            throw new DaoException(ex);
        } finally {
        	pool.freeConnection(connection);
        }
        
	}
	
	@Override
	public boolean checkUser(String mail, String username, String password) throws DaoException {
		Connection connection = null;
		Statement statement;
		ResultSet resultSet;
		ConnectionPool pool = ConnectionPool.getInstance();
		PreparedStatement ps;
		String hashPasswrd;
    	byte[] salt;
		try {
			String query = String.format(CHECK_USER_BY_MAIL, mail);
            connection = pool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (!resultSet.next()) {
            	ps = connection.prepareStatement(REGISTRATION_QUERY);
            	salt = hash.makeSalt();
            	hashPasswrd = hash.hashPasswordWithSalt(password, salt);
            	ps.setString(1, username);
            	ps.setString(2, hashPasswrd);
            	ps.setInt(3, 0);
            	ps.setString(4, new String(salt));
            	ps.setString(5, mail);
            	ps.executeUpdate();
            	return true;
            } 
            return false;

        } catch (SQLException | ConnectionPoolException ex) {
            throw new DaoException(ex);
        } finally {
			pool.freeConnection(connection);
		}
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
	public ArrayList<Book> getBooksByUserId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addOrder(int user_id, int book_id, Statment st) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}


	
	
    
}
