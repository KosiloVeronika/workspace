package com.epam.libraryManager.logic;

import java.util.Locale;

import org.apache.log4j.Logger;

public class LocaleDefiner {
	private final static Logger LOG = Logger.getLogger(LocaleDefiner.class);
	public LocaleDefiner() { }
	
	public static Locale defineLocale(String language) throws LogicException {
		LOG.info("мы в логике");
		if(language == null || language.isEmpty()) {
			throw new LogicException("!");
		}
		Locale locale = new Locale("en", "EN"); 
		if("russian".equals(language)) {
			locale = new Locale("ru", "RU");
		}
		return locale;
		
	}

}
