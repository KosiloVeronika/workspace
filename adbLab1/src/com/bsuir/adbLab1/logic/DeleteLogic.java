package com.bsuir.adbLab1.logic;

import com.bsuir.adbLab1.dao.DaoException;
import com.bsuir.adbLab1.dao.UserDAO;

public class DeleteLogic {

	public DeleteLogic() {}
	
	public static boolean delete(int id) throws LogicException {
		UserDAO userDao = new UserDAO();
		try {
			return userDao.deleteUser(id);
		} catch (DaoException e) {
			throw new LogicException("cant dlt", e);
		}
	}

}