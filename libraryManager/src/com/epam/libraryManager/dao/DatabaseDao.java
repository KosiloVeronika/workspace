package com.epam.libraryManager.dao;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.epam.libraryManager.connectionpool.ConnectionPool;
import com.epam.libraryManager.connectionpool.ConnectionPoolException;
import com.epam.libraryManager.entity.User;
import com.epam.libraryManager.resource.ConfigurationManager;

public class DatabaseDao implements DataAccessDao {
	private final String CHECK_USER_BY_USERNAME = "SELECT * FROM `user` WHERE username = '%s' ";
	private final String CHECK_USER_BY_MAIL = "SELECT * FROM `user` WHERE mail = '%s' ";
	private final String REGISTRATION_QUERY = "INSERT INTO user(mail, password, salt, admin, username) VALUES(?,?,?,?,?)";
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
   
	@Override
	public User getUserFromSource(String username, String password) throws DaoException {

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
                if(hashPasswordWithSalt(password, salt).equals(hashPassword)) {
                	System.out.println("WTF");
                	user = new User();
                	user.setUsername(resultSet.getString("username"));
                    user.setIsAdmin(resultSet.getInt("admin"));
                }
                System.out.println(user.toString());
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
            	salt = makeSalt();
            	hashPasswrd = hashPasswordWithSalt(password, salt);
            	System.out.println(hashPasswrd);
            	ps.setString(1, mail);
            	ps.setString(2, hashPasswrd);
            	ps.setString(3, new String(salt));
            	ps.setInt(4, 0);
            	ps.setString(5, username);
            	ps.executeUpdate();
            	return true;
            } 
            return false;

        } catch (SQLException | ConnectionPoolException ex) {
            throw new DaoException(ex);
        } finally {
        	//closeStatement(ps);
			pool.freeConnection(connection);
		}
	}
	
	private String hashPasswordWithSalt(String password, byte[] salt) throws DaoException {
		password += ConfigurationManager.getProperty("crypt.localParameter");
		PBEKeySpec pbe = new PBEKeySpec(password.toCharArray(), salt, 4096, 1024);
		byte[] keyArray;
		try {
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			SecretKey key = secretKeyFactory.generateSecret(pbe);
			keyArray = key.getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new DaoException(e);
		} 
		return new String(keyArray);
	}
	
	private byte[] makeSalt() {
		Random random = new Random();
		int saltLength = 12 + random.nextInt(6); 
		byte[] salt = new byte[saltLength];
		random.nextBytes(salt);
		return salt;
	}
    
}
