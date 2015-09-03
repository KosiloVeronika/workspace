package com.epam.libraryManager.logic;

import com.epam.libraryManager.dao.DataAccessDao;
import com.epam.libraryManager.dao.DataAccessException;
import com.epam.libraryManager.dao.DatabaseDao;

public class RegistrationLogic {

	public RegistrationLogic() {
	}
	public static boolean RegisterUser(String mail, String username, String password) throws LogicException {
		DataAccessDao dataaccess = new DatabaseDao();
		try {
			return dataaccess.checkUser(mail, username, password);
		} catch (DataAccessException e) {
			throw new LogicException(e.getMessage(), e);
		}
		
	}
}
