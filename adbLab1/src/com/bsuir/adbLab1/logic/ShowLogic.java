package com.bsuir.adbLab1.logic;

import java.util.ArrayList;

import com.bsuir.adbLab1.dao.DaoException;
import com.bsuir.adbLab1.dao.UserDAO;
import com.bsuir.adbLab1.entity.User;

public class ShowLogic {

	public ShowLogic() {
		
	}
	
	public static ArrayList<User> Show() throws LogicException {
		UserDAO userDao = new UserDAO();
		ArrayList<User> users = new ArrayList<User>();
		try {
			users = userDao.getUserList();
			return users;
		} catch (DaoException e) {
			throw new LogicException("bla bla", e);
		}
	}
	
	public static User changeUser(int id) throws LogicException {
		UserDAO userDao = new UserDAO();
		User user = null;
		try {
			user = userDao.getUserByID(id);
			return user;
		} catch (DaoException e) {
			throw new LogicException("bla bla", e);
		}
	}
}
