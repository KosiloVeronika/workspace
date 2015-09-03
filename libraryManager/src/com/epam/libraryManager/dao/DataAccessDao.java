package com.epam.libraryManager.dao;

import com.epam.libraryManager.entity.Library;
import com.epam.libraryManager.entity.User;

public interface DataAccessDao {
	public Library getLibraryFromSource(Object ... args) throws DataAccessException;
	public User getUserFromSource(String username) throws DataAccessException;
	public boolean checkUser(String mail, String username, String password) throws DataAccessException;
}