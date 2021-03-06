package com.epam.libraryManager.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.epam.libraryManager.logic.LogicException;
import com.epam.libraryManager.logic.RegistrationLogic;
import com.epam.libraryManager.resource.ConfigurationManager;
import com.epam.libraryManager.resource.MessageManager;

public class RegistrationCommand implements ICommand {

	private final static Logger LOG = Logger.getLogger(LoginCommand.class);
	private static final String PARAM_NAME_LOGIN = "username";
	private static final String PARAM_NAME_PASSWORD = "password";
	private static final String PARAM_NAME_EMAIL = "mail";

	public RegistrationCommand() {
	}

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		// ���������� �� ������� ������ � ������
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		String email = request.getParameter(PARAM_NAME_EMAIL);
		// �������� ������ � ������
		try {
			if (RegistrationLogic.registerUser(email, login, pass)) {
				request.setAttribute("user", login);
				// ����������� ���� � main.jsp
				page = ConfigurationManager.getProperty("path.page.main");
				//page = "/jsp/main.jsp";
			} else {
				request.setAttribute("errorRegistrationPassMessage",
				MessageManager.getProperty("message.registrationerror"));
				page = ConfigurationManager.getProperty("path.page.registration");
			}
		} catch (LogicException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}

}
