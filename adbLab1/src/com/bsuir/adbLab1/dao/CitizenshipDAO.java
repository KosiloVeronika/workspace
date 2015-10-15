package com.bsuir.adbLab1.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bsuir.adbLab1.connectionpool.ConnectionPool;
import com.bsuir.adbLab1.connectionpool.ConnectionPoolException;
import com.bsuir.adbLab1.entity.Citizenship;
import com.bsuir.adbLab1.entity.City;
import com.bsuir.adbLab1.entity.Disability;
import com.bsuir.adbLab1.entity.MStatus;
import com.bsuir.adbLab1.entity.User;

public class CitizenshipDAO implements DataAccessDao {
	private final String GET_LIST = "SELECT * FROM `citizenship`";
	private final String GET_CTZN = "SELECT * FROM `citizenship` WHERE `citizenship_id` = %d";
	public CitizenshipDAO() {
	}
	public Citizenship getCitizenshipById(int id) throws DaoException {
		Citizenship citizenship = null;
		Connection connection = null;
		Statement statement;
		ResultSet resultSet;
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            connection = pool.getConnection();
            statement = connection.createStatement();
            String query = String.format(GET_CTZN, id);
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
            	citizenship =  new Citizenship();
            	citizenship.setId(resultSet.getInt("citizenship_id"));
            	citizenship.setCitizenship(resultSet.getString("citizenship_name"));
            }
        	statement.close();
            return citizenship;

        } catch (SQLException | ConnectionPoolException ex) {
            throw new DaoException(ex);
        } finally {
        	pool.freeConnection(connection);
        }
    }
	@Override
	public ArrayList<City> getCityList() throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<MStatus> getStatusList() throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<Citizenship> getCitizenshipList() throws DaoException {
		ArrayList<Citizenship> list = new ArrayList<Citizenship>();
		Citizenship citizenship = null;
		Connection connection = null;
		Statement statement;
		ResultSet resultSet;
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            connection = pool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_LIST);
            while (resultSet.next()) {
            	citizenship =  new Citizenship();
            	citizenship.setId(resultSet.getInt("citizenship_id"));
            	citizenship.setCitizenship(resultSet.getString("citizenship_name"));
                list.add(citizenship);
            }
        	statement.close();
            return list;

        } catch (SQLException | ConnectionPoolException ex) {
            throw new DaoException(ex);
        } finally {
        	pool.freeConnection(connection);
        }
	}

	@Override
	public ArrayList<Disability> getDisabilityList() throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public User showUser(int id) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<User> getUserList() throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean changeUser(User user) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addUser(User user) throws DaoException {
		throw new UnsupportedOperationException();
	}

}
