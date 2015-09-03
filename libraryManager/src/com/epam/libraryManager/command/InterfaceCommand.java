package com.epam.libraryManager.command;

import javax.servlet.http.HttpServletRequest;

public interface InterfaceCommand {
	public String execute(HttpServletRequest request);
}
