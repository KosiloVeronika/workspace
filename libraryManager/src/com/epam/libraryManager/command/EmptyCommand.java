package com.epam.libraryManager.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.epam.libraryManager.resource.ConfigurationManager;

public class EmptyCommand implements InterfaceCommand {
	private final static Logger LOG = Logger.getLogger(EmptyCommand.class);
	@Override
	public String execute(HttpServletRequest request) {
		/* в случае ошибки или прямого обращения к контроллеру
		* переадресация на страницу ввода логина */
		String page = ConfigurationManager.getProperty("path.page.login");
		return page;
	}

}
