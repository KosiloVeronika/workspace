package com.epam.libraryManager.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.libraryManager.logic.LocaleDefiner;
import com.epam.libraryManager.logic.LogicException;
import com.epam.libraryManager.resource.ConfigurationManager;

public class ChangeLocaleCommand implements ICommand {
	private final static Logger LOG = Logger.getLogger(ChangeLocaleCommand.class);
	private static ChangeLocaleCommand instance = new ChangeLocaleCommand();
	
	public ChangeLocaleCommand() { }
	
	public ChangeLocaleCommand getInstance() {
		return instance;
	}

	@Override
	public String execute(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		try {
			session.setAttribute("locale", LocaleDefiner.defineLocale(request.getParameter("language")));
		} catch (LogicException ex) {
			LOG.error(ex);
		}
		String jspPath = ConfigurationManager.getProperty("path.page.index");
		return jspPath;
	}

}
