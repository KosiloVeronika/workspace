package com.epam.libraryManager.logic;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.epam.libraryManager.dao.DaoException;
import com.epam.libraryManager.dao.OrderDAO;
import com.epam.libraryManager.entity.Order;

public class ShowAllOrdersLogic {

	private final static Logger LOG = Logger.getLogger(ShowAllOrdersLogic.class);
	public static ArrayList<Order> getAllOrders(int id) throws LogicException {
		OrderDAO orderDAO = new OrderDAO();
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
			orders = orderDAO.getOrdersByUserId(id);
			//if(books != null) {
				//return books;
			//}
			return orders;
		} catch (DaoException e) {
			throw new LogicException("bla bla", e);
		}
	}

}
