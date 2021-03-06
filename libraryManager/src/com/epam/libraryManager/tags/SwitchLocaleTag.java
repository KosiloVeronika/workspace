package com.epam.libraryManager.tags;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class SwitchLocaleTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SwitchLocaleTag() {
	}
	
	@Override
	public int doStartTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		HttpSession session = request.getSession(true);
		Locale locale = (Locale) session.getAttribute("locale");
		if(locale == null) {
			locale = Locale.getDefault();
		}
		String localeToString = locale.toString();
		try {
			if("ru_RU".equals(localeToString)) {
				pageContext.include("/jspf/en_locale.jspf");
			} else {
				pageContext.include("/jspf/en_locale.jspf");
			}
		} catch(ServletException | IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}
