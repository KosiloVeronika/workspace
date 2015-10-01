package com.epam.libraryManager.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.epam.libraryManager.resource.ConfigurationManager;

public class LogoutCommand implements ICommand {
	private final static Logger LOG = Logger.getLogger(LogoutCommand.class);
	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.index");
		// ����������� ������
		request.getSession().invalidate();
		return page;
	}

}
