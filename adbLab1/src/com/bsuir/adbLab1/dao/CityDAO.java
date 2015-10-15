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

public class CityDAO implements DataAccessDao {
	private final String GET_LIST = "SELECT * FROM `city`";
	private final String GET_CITY = "SELECT * FROM `city` WHERE `city_id` = %d";

	public CityDAO() {
	}

	public City getCityById(int id) throws DaoException {
		City city = null;
		Connection connection = null;
		Statement statement;
		ResultSet resultSet;
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            connection = pool.getConnection();
            String query = String.format(GET_CITY, id);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
            	city =  new City();
            	city.setId(resultSet.getInt("city_id"));
            	city.setCity(resultSet.getString("name"));
            }
        	statement.close();
            return city;

        } catch (SQLException | ConnectionPoolException ex) {
            throw new DaoException(ex);
        } finally {
        	pool.freeConnection(connection);
        }
	}
	@Override
	public ArrayList<City> getCityList() throws DaoException {
		ArrayList<City> list = new ArrayList<City>();
		City city = null;
		Connection connection = null;
		Statement statement;
		ResultSet resultSet;
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            connection = pool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_LIST);
            while (resultSet.next()) {
            	city =  new City();
            	city.setId(resultSet.getInt("city_id"));
            	city.setCity(resultSet.getString("name"));
                list.add(city);
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
	public ArrayList<MStatus> getStatusList() throws DaoException {
		throw new UnsupportedOperationException();
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
