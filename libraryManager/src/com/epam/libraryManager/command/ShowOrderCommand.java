package com.epam.libraryManager.command;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.epam.libraryManager.logic.LogicException;
import com.epam.libraryManager.logic.ShowAllOrdersLogic;
import com.epam.libraryManager.resource.ConfigurationManager;

public class ShowOrderCommand implements ICommand {

	private final static Logger LOG = Logger.getLogger(ShowOrderCommand.class);
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		try {
				request.setAttribute("user", request.getSession(true).getAttribute("user"));
				request.setAttribute("user_id", request.getSession(true).getAttribute("user_id"));
				int userID = (int)request.getSession(true).getAttribute("user_id");
				request.setAttribute("orders", ShowAllOrdersLogic.getAllOrders(userID));
				// определение пути к main.jsp
				LOG.debug("WE SHOW YOU ORDERS");
				page = ConfigurationManager.getProperty("path.page.showOrders");

		} catch (LogicException ex) {
			LOG.error("SHOW ALL ORDERS", ex);
		}
		return page;
	}

}
