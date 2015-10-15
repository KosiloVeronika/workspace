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

public class DisabilityDAO implements DataAccessDao {
	private final String GET_LIST = "SELECT * FROM `disability`";
	private final String GET_DSBLT = "SELECT * FROM `disability` WHERE `disability_id` = %d";

	public DisabilityDAO() {
	}
	public Disability getDisabilityById(int id) throws DaoException {
		Disability disability = null;
		Connection connection = null;
		Statement statement;
		ResultSet resultSet;
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            connection = pool.getConnection();
            statement = connection.createStatement();
            String query = String.format(GET_DSBLT, id);
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
            	disability =  new Disability();
            	disability.setId(resultSet.getInt("disability_id"));
            	disability.setDisability(resultSet.getString("disability_category"));
            }
        	statement.close();
            return disability;

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
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<Disability> getDisabilityList() throws DaoException {
		ArrayList<Disability> list = new ArrayList<Disability>();
		Disability disability = null;
		Connection connection = null;
		Statement statement;
		ResultSet resultSet;
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            connection = pool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_LIST);
            while (resultSet.next()) {
            	disability =  new Disability();
            	disability.setId(resultSet.getInt("disability_id"));
            	disability.setDisability(resultSet.getString("disability_category"));
                list.add(disability);
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
