package com.epam.libraryManager.logic;

import com.epam.libraryManager.dao.DaoException;
import com.epam.libraryManager.dao.DataAccessDao;
import com.epam.libraryManager.dao.DatabaseDao;

public class RegistrationLogic {

	public RegistrationLogic() {
	}
	public static boolean registerUser(String mail, String username, String password) throws LogicException {
		DataAccessDao dataaccess = new DatabaseDao();
		try {
			return dataaccess.checkUser(mail, username, password);
		} catch (DaoException e) {
			throw new LogicException(e.getMessage(), e);
		}
		
	}
}
