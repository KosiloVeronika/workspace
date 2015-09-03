package com.epam.libraryManager.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.libraryManager.command.CommandFactory;
import com.epam.libraryManager.command.InterfaceCommand;
import com.epam.libraryManager.resource.ConfigurationManager;
import com.epam.libraryManager.resource.MessageManager;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	 static {
		 	System.out.println("hello kiti");
		 	
		}
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(Controller.class);       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
		LOG.error("7");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		LOG.error("7");
		LOG.debug("PROCREQ");
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String page = null;
			LOG.debug("PROCREQ");
			// ����������� �������, ��������� �� JSP
			CommandFactory client = new CommandFactory();
			InterfaceCommand command = client.defineCommand(request);
			/*
			* ����� �������������� ������ execute() � �������� ����������
			* ������-����������� ���������� �������
			 */
			page = command.execute(request);
			// ����� ���������� �������� ������
			// page = null; // ��������������������!
			if (page != null) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
				// ����� �������� ������ �� ������
				dispatcher.forward(request, response);
			} else {
				// ��������� �������� c c��������� �� ������
				page = ConfigurationManager.getProperty("path.page.index");
				request.getSession().setAttribute("nullPage",
				MessageManager.getProperty("message.nullpage"));
				response.sendRedirect(request.getContextPath() + page);
			}
	}

}