package com.epam.libraryManager.dao;

import com.epam.libraryManager.entity.User;

public interface DataAccessDao {
	User getUserFromSource(String username, String password) throws DaoException;
	boolean checkUser(String mail, String username, String password) throws DaoException;
}
