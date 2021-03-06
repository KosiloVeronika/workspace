package com.bsuir.adbLab1.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;


@WebListener
public class ContextListener implements ServletContextListener {
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  {
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	String absPath = event.getServletContext().getRealPath("/")+"WEB-INF\\log4j.xml";
    			new DOMConfigurator().doConfigure(absPath,LogManager.getLoggerRepository());
    			//System.out.println("absPath"+absPath);
    }
	
}
