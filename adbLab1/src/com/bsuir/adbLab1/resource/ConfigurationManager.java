package com.bsuir.adbLab1.resource;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class ConfigurationManager {
	private final static Logger LOG = Logger.getLogger(ConfigurationManager.class);
	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.config");
	// класс извлекает информацию из файла config.properties
	private ConfigurationManager() { }
	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}
