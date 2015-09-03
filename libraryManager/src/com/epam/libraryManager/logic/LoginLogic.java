package com.epam.libraryManager.logic;

import org.apache.log4j.Logger;

import com.epam.libraryManager.dao.DataAccessDao;
import com.epam.libraryManager.dao.DataAccessException;
import com.epam.libraryManager.dao.DatabaseDao;
import com.epam.libraryManager.entity.User;

public class LoginLogic {
	private final static Logger LOG = Logger.getLogger(LoginLogic.class);
	public static boolean checkLogin(String enterLogin, String enterPass) throws LogicException {
		DataAccessDao dataaccess = new DatabaseDao();
		try {
			User user = dataaccess.getUserFromSource(enterLogin);
			return user.getPassword().equals(enterPass) && user.getUsername().equals(enterLogin);
		} catch (DataAccessException e) {
			throw new LogicException(e.getMessage(), e);
		}
		
		//return ADMIN_LOGIN.equals(enterLogin) && ADMIN_PASS.equals(enterPass);
	}

}
