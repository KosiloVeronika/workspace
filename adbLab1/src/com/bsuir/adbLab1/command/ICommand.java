package com.bsuir.adbLab1.command;

import javax.servlet.http.HttpServletRequest;

public interface ICommand {
	String execute(HttpServletRequest request);
}
