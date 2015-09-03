package com.epam.libraryManager.listener;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {
	private Connection connection;
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  {
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	ServletContext context = event.getServletContext();
    	String absPath = event.getServletContext().getRealPath("/")+"WEB-INF\\log4j.xml";
    			new DOMConfigurator().doConfigure(absPath,LogManager.getLoggerRepository());
    			System.out.println("absPath"+absPath);
    	//String mailFeedback = context.getInitParameter("feedback");
    	//context.log("Context Initialized with parameter: " + mailFeedback);
    	//System.out.println("Context Initialized with parameter: " + mailFeedback);
    }
	
}