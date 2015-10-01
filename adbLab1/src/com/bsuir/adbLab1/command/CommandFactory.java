package com.bsuir.adbLab1.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.bsuir.adbLab1.resource.MessageManager;

public class CommandFactory {

	public CommandFactory() { }
	
	private final static Logger LOG = Logger.getLogger(CommandFactory.class);	
	public ICommand defineCommand(HttpServletRequest request) {
		LOG.debug("Ã€ ¬ ‘¿¡–» ≈");
		ICommand current = new EmptyCommand();
		String action = request.getParameter("command");
		if (action == null || action.isEmpty()) {
			return current;
		}
		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction", action
			+ MessageManager.getProperty("message.wrongaction"));
		}
			return current;
		}

}
