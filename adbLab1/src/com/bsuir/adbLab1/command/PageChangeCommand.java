package com.bsuir.adbLab1.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.bsuir.adbLab1.logic.ListboxLogic;
import com.bsuir.adbLab1.logic.LogicException;
import com.bsuir.adbLab1.logic.ShowLogic;
import com.bsuir.adbLab1.resource.ConfigurationManager;

public class PageChangeCommand implements ICommand {
	private static final Logger LOG = Logger.getLogger(PageChangeCommand.class);

	public PageChangeCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		try {
			int id = Integer.parseInt(request.getParameter("user_id"));
			request.setAttribute("cityList", ListboxLogic.getCity());
			request.setAttribute("martialList", ListboxLogic.getStatus());
			request.setAttribute("citizenshipList", ListboxLogic.getCtzn());
			request.setAttribute("disabilityList", ListboxLogic.getDsblt());
			request.setAttribute("user", ShowLogic.changeUser(id));
				// определение пути к main.jsp
			LOG.debug("WE SHOW YOU user you wanna change");
			page = ConfigurationManager.getProperty("path.page.edit");

		} catch (LogicException ex) {
			LOG.error("SHOW ALL BOOKS", ex);
		}
		return page;
	}

}
