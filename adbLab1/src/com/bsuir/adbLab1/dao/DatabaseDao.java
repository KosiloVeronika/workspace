package com.bsuir.adbLab1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bsuir.adbLab1.connectionpool.ConnectionPool;
import com.bsuir.adbLab1.connectionpool.ConnectionPoolException;
import com.bsuir.adbLab1.entity.City;
import com.bsuir.adbLab1.entity.User;

public class DatabaseDao implements DataAccessDao {
	private final String CHECK_USER_BY_USERNAME = "SELECT * FROM `user` WHERE username = '%s' ";
	private final String CITIES = "SELECT * FROM `city`";
	private final String CHECK_USER_BY_MAIL = "SELECT * FROM `user` WHERE mail = '%s' ";
	private final String REGISTRATION_QUERY = "INSERT INTO user(mail, password, salt, admin, username) VALUES(?,?,?,?,?)";
   
	public ArrayList<City> getCity() throws DaoException {
		ArrayList<City> cities = new ArrayList<>();
		Connection connection = null;
		Statement statement;
		ResultSet resultSet;
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            connection = pool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(CITIES);
            while (resultSet.next()) {
                //cities.add(new City())
            }
            //return user;

        } catch (SQLException | ConnectionPoolException ex) {
            throw new DaoException(ex);
        } finally {
        	pool.freeConnection(connection);
        }
		return cities;
	}
	
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
		try {
			String query = String.format(CHECK_USER_BY_MAIL, mail);
            connection = pool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (!resultSet.next()) {
            	ps = connection.prepareStatement(REGISTRATION_QUERY);
            	ps.setString(1, mail);
            	//ps.setString(2, hashPasswrd);
            	//ps.setString(3, new String(salt));
            	ps.setInt(4, 0);
            	ps.setString(5, username);
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
	
	
    
}
