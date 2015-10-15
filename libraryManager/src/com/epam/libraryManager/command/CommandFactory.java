package com.epam.libraryManager.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.epam.libraryManager.resource.MessageManager;

public class CommandFactory {
	private final static Logger LOG = Logger.getLogger(CommandFactory.class);	
	public ICommand defineCommand(HttpServletRequest request) {
		LOG.info("МЫ В ФАБРИКЕ");
		ICommand current = new EmptyCommand();
			// извлечение имени команды из запроса
		String action = request.getParameter("command");
		LOG.info(action);
		if (action == null || action.isEmpty()) {
			// если команда не задана в текущем запросе
			return current;
		}
			// получение объекта, соответствующего команде
		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction", action
			+ MessageManager.getProperty("message.wrongaction") + e.getMessage());
		}
			return current;
		}
}
