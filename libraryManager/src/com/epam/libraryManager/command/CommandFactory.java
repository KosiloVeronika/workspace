package com.epam.libraryManager.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.epam.libraryManager.resource.MessageManager;

public class CommandFactory {
	private final static Logger LOG = Logger.getLogger(CommandFactory.class);	
	public InterfaceCommand defineCommand(HttpServletRequest request) {
		LOG.info("�� � �������");
		InterfaceCommand current = new EmptyCommand();
			// ���������� ����� ������� �� �������
		String action = request.getParameter("command");
		if (action == null || action.isEmpty()) {
			// ���� ������� �� ������ � ������� �������
			return current;
		}
			// ��������� �������, ���������������� �������
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
