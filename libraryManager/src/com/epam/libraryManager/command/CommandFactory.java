package com.epam.libraryManager.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.epam.libraryManager.resource.MessageManager;

public class CommandFactory {
	private final static Logger LOG = Logger.getLogger(CommandFactory.class);	
	public InterfaceCommand defineCommand(HttpServletRequest request) {
		InterfaceCommand current = new EmptyCommand();
			// извлечение имени команды из запроса
		String action = request.getParameter("command");
		if (action == null || action.isEmpty()) {
			// если команда не задана в текущем запросе
			return current;
		}
			// получение объекта, соответствующего команде
		try {
			EnumCommand currentEnum = EnumCommand.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction", action
			+ MessageManager.getProperty("message.wrongaction"));
		}
			return current;
		}
}
