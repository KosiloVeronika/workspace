package com.epam.libraryManager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.epam.libraryManager.connectionpool.ConnectionPool;
import com.epam.libraryManager.connectionpool.ConnectionPoolException;
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
                	System.out.println("WTF");
                	user = new User();
                	user.setUsername(resultSet.getString("login"));System.out.println("WTF");
                    user.setUsertype(resultSet.getInt("id_user_type_fk"));
                }System.out.println("WTF");
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
            	System.out.println(hashPasswrd);
            	ps.setString(1, username);
            	System.out.println("�������� ����");
            	ps.setString(2, hashPasswrd);
            	System.out.println("��� ����");
            	ps.setInt(3, 0);
            	System.out.println("����� ����");
            	ps.setString(4, new String(salt));
            	System.out.println("���� ����");
            	ps.setString(5, mail);
            	System.out.println("���� ����");
            	ps.executeUpdate();
            	System.out.println("�����");
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
