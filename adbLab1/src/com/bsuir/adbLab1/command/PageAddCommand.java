package com.bsuir.adbLab1.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.bsuir.adbLab1.logic.ListboxLogic;
import com.bsuir.adbLab1.logic.LogicException;
import com.bsuir.adbLab1.resource.ConfigurationManager;

public class PageAddCommand implements ICommand {
	private static final Logger LOG = Logger.getLogger(PageAddCommand.class);

	public PageAddCommand() {}

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		try {
			request.setAttribute("cityList", ListboxLogic.getCity());
			request.setAttribute("martialList", ListboxLogic.getStatus());
			request.setAttribute("citizenshipList", ListboxLogic.getCtzn());
			request.setAttribute("disabilityList", ListboxLogic.getDsblt());
				// ����������� ���� � main.jsp
			LOG.debug("WE ADD USER");
			page = ConfigurationManager.getProperty("path.page.add");

		} catch (LogicException ex) {
			LOG.error("something wrong there in page add command", ex);
		}
		return page;
	}

}
