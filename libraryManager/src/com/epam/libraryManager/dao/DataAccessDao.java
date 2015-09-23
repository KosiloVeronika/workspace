package com.epam.libraryManager.dao;

import com.epam.libraryManager.entity.User;

public interface DataAccessDao {
	public User getUserFromSource(String username, String password) throws DaoException;
	public boolean checkUser(String mail, String username, String password) throws DaoException;
}
