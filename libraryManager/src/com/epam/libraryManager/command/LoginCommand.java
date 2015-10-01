package com.epam.libraryManager.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.epam.libraryManager.logic.LogicException;
import com.epam.libraryManager.logic.LoginLogic;
import com.epam.libraryManager.resource.ConfigurationManager;
import com.epam.libraryManager.resource.MessageManager;

public class LoginCommand implements ICommand {
	private final static Logger LOG = Logger.getLogger(LoginCommand.class);
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		// извлечение из запроса логина и пароля
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		// проверка логина и пароля
		try {
			if (LoginLogic.checkLogin(login, pass)) {
				request.setAttribute("user", login);
				// определение пути к main.jsp
				LOG.debug("user has been logged");
				page = ConfigurationManager.getProperty("path.page.main");
			} else {
				request.setAttribute("errorLoginPassMessage",
				MessageManager.getProperty("message.loginerror"));
				page = ConfigurationManager.getProperty("path.page.login");
			}
		} catch (LogicException ex) {
			LOG.error("LOGIN ERROR", ex);
		}
		return page;
	}

}
