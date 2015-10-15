package com.epam.libraryManager.logic;

import org.apache.log4j.Logger;

import com.epam.libraryManager.dao.DaoException;
import com.epam.libraryManager.dao.DataAccessDao;
import com.epam.libraryManager.dao.DatabaseDao;
import com.epam.libraryManager.entity.User;

public class LoginLogic {
	private final static Logger LOG = Logger.getLogger(LoginLogic.class);
	
	public static User checkLogin(String enterLogin, String enterPass) throws LogicException {
		DataAccessDao dataaccess = new DatabaseDao();
		try {
			User user = dataaccess.getUserFromSource(enterLogin, enterPass);
			return user;
		} catch (DaoException ex) {
			throw new LogicException("Can't execute user", ex);
		}
	}

}
