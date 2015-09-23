package com.epam.libraryManager.resource;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class MessageManager {
	private final static Logger LOG = Logger.getLogger(MessageManager.class);
	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.messages");
	// класс извлекает информацию из файла messages.properties
	private MessageManager() { }
	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}
