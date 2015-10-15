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

public class StatusDAO implements DataAccessDao {
	private final String GET_LIST = "SELECT * FROM `m_status`";
	private final String GET_STATUS = "SELECT * FROM `m_status` WHERE `marital_status_id` = %d";

	public StatusDAO() {
	}
	
	public MStatus getStatusById(int id) throws DaoException {
		MStatus status = null;
		Connection connection = null;
		Statement statement;
		ResultSet resultSet;
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            connection = pool.getConnection();
            String query = String.format(GET_STATUS, id);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
            	status =  new MStatus();
            	status.setId(resultSet.getInt("marital_status_id"));
            	status.setStatus(resultSet.getString("status"));
            }
        	statement.close();
            return status;

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
		ArrayList<MStatus> list = new ArrayList<MStatus>();
		MStatus status = null;
		Connection connection = null;
		Statement statement;
		ResultSet resultSet;
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            connection = pool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_LIST);
            while (resultSet.next()) {
            	status =  new MStatus();
            	status.setId(resultSet.getInt("marital_status_id"));
            	status.setStatus(resultSet.getString("status"));
                list.add(status);
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
	public ArrayList<Citizenship> getCitizenshipList() throws DaoException {
		throw new UnsupportedOperationException();
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
