package com.bsuir.adbLab1.logic;

import com.bsuir.adbLab1.dao.DaoException;
import com.bsuir.adbLab1.dao.UserDAO;
import com.bsuir.adbLab1.entity.User;

public class ChangeLogic {

	public ChangeLogic() {}
	public static boolean change(User user,int id) throws LogicException {
		UserDAO userDao = new UserDAO();
		System.out.println(id+"from change logic");
		user.setUserID(id);
		try {
			return userDao.changeUser(user);
		} catch (DaoException e) {
			throw new LogicException("bla bla", e);
		}
	}
	
}