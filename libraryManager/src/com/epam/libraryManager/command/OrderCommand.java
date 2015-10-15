package com.epam.libraryManager.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.epam.libraryManager.entity.Statment;
import com.epam.libraryManager.logic.LogicException;
import com.epam.libraryManager.logic.OrderLogic;
import com.epam.libraryManager.logic.ShowAllBooksLogic;
import com.epam.libraryManager.resource.ConfigurationManager;
import com.epam.libraryManager.resource.MessageManager;

public class OrderCommand implements ICommand {

	private final static Logger LOG = Logger.getLogger(OrderCommand.class);

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		try {
			LOG.debug(request.getSession(true).getAttribute("user_id"));
			LOG.debug(request.getParameter("book_id"));
			LOG.debug(request.getParameter("st"));
			int userID = Integer.parseInt(request.getSession(true).getAttribute("user_id").toString());
			int bookID = Integer.parseInt(request.getParameter("book_id").toString());
			Statment st = Statment.valueOf(request.getParameter("st").toString());
				request.setAttribute("user", request.getSession(true).getAttribute("user"));
				request.setAttribute("user_id", request.getSession(true).getAttribute("user_id"));
				if (OrderLogic.addOrder(userID, bookID, st)) {

					LOG.debug("order was confirmed");
					request.setAttribute("errorOrderMessage",
					MessageManager.getProperty("message.orderOK"));
					//request.setAttribute("user", login);
					LOG.debug("order was confirmed");
					request.setAttribute("books", ShowAllBooksLogic.getAllBooks());
					// определение пути к main.jsp
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
