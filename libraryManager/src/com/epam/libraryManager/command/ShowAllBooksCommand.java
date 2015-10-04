package com.epam.libraryManager.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.epam.libraryManager.logic.LogicException;
import com.epam.libraryManager.logic.LoginLogic;
import com.epam.libraryManager.logic.ShowAllBooksLogic;
import com.epam.libraryManager.resource.ConfigurationManager;

public class ShowAllBooksCommand implements ICommand {

	private final static Logger LOG = Logger.getLogger(LoginLogic.class);
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		try {
				request.setAttribute("books", ShowAllBooksLogic.getAllBooks());
				// ����������� ���� � main.jsp
				LOG.debug("WE SHOW YOU BOOKS");
				page = ConfigurationManager.getProperty("path.page.showAll");

		} catch (LogicException ex) {
			LOG.error("SHOW ALL BOOKS", ex);
		}
		return page;
	}

}