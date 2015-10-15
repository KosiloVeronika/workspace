package com.bsuir.adbLab1.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.bsuir.adbLab1.logic.DeleteLogic;
import com.bsuir.adbLab1.logic.LogicException;
import com.bsuir.adbLab1.logic.ShowLogic;
import com.bsuir.adbLab1.resource.ConfigurationManager;

public class DeleteCommand implements ICommand {

	private static final Logger LOG = Logger.getLogger(DeleteCommand.class);
	public DeleteCommand() {
	}

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		try {
			int id = Integer.parseInt(request.getParameter("user_id"));
			LOG.debug("WE DELETE user");
			DeleteLogic.delete(id);
			request.setAttribute("users", ShowLogic.Show());
			LOG.debug("WE SHOW YOU users");
			page = ConfigurationManager.getProperty("path.page.main");

		} catch (LogicException ex) {
			LOG.error("SHOW ALL BOOKS", ex);
		}
		return page;
	}

}
