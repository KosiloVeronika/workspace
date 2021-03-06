package com.epam.libraryManager.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.epam.libraryManager.entity.Statment;
import com.epam.libraryManager.logic.LogicException;
import com.epam.libraryManager.logic.OrderLogic;
import com.epam.libraryManager.logic.ShowAllBooksLogic;
import com.epam.libraryManager.resource.ConfigurationManager;
import com.epam.libraryManager.resource.MessageManager;

public class CancelOrderCommand implements ICommand {

	private final static Logger LOG = Logger.getLogger(CancelOrderCommand.class);
	public CancelOrderCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		try {
			LOG.debug(request.getSession(true).getAttribute("user_id"));
			LOG.debug(request.getParameter("order_id"));
			Statment st = Statment.valueOf(request.getParameter("st").toString());
			int order_id = Integer.parseInt(request.getParameter("order_id").toString());
				request.setAttribute("user", request.getSession(true).getAttribute("user"));
				request.setAttribute("user_id", request.getSession(true).getAttribute("user_id"));
				if (OrderLogic.cancelOrder(order_id)) {

					LOG.debug("order was canceld");
					request.setAttribute("errorOrderMessage",
					MessageManager.getProperty("message.orderOK"));
					LOG.debug("order was confirmed");
					request.setAttribute("books", ShowAllBooksLogic.getAllBooks());
					// ����������� ���� � main.jsp
					LOG.debug("WE SHOW YOU BOOKS");
					page = ConfigurationManager.getProperty("path.page.showAll");
				} else {
					request.setAttribute("errorOrderMessage",
					MessageManager.getProperty("message.order"));
					page = ConfigurationManager.getProperty("path.page.showAll");
				}
				

		} catch (LogicException ex) {
			LOG.error("SHOW ALL BOOKS", ex);
		}
		return page;
	}

}
