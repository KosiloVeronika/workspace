package com.epam.libraryManager.dao;

import com.epam.libraryManager.entity.User;

public class UserDAO implements DataAccessDao {

	public UserDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User getUserFromSource(String username, String password) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkUser(String mail, String username, String password) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

}
