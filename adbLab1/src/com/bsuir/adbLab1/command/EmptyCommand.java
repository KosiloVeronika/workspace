package com.bsuir.adbLab1.command;

import javax.servlet.http.HttpServletRequest;

import com.bsuir.adbLab1.resource.ConfigurationManager;

public class EmptyCommand implements ICommand {

	public EmptyCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(HttpServletRequest request) {
		/* � ������ ������ ��� ������� ��������� � �����������
		* ������������� �� �������� ����� ������ */
		String page = ConfigurationManager.getProperty("path.page.login");
		return page;
	}

}
