package com.epam.libraryManager.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.epam.libraryManager.entity.User;
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
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		try {
			User user = LoginLogic.checkLogin(login, pass);
			if (user != null) {
				request.getSession(true).setAttribute("user", login);
				request.getSession(true).setAttribute("admin", user.getUsertype());

				LOG.debug(user.getUserID());
				request.getSession(true).setAttribute("user_id", user.getUserID());
				//request.setAttribute("user", login);
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
