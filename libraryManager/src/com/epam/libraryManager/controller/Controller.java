package com.epam.libraryManager.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		LOG.error("7");
		LOG.debug("PROCREQ");
		LOG.info("whyyyyyyy?");
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String page = null;
			//HttpSession session = request.getSession(true);
			//LOG.info("whyyyyyyy?");
			// ����������� �������, ��������� �� JSP
			CommandFactory client = new CommandFactory();
			System.out.println(request.getParameter("command"));
			System.out.println(request.getParameter("language"));
			InterfaceCommand command = client.defineCommand(request);
			/*
			* ����� �������������� ������ execute() � �������� ����������
			* ������-����������� ���������� �������
			 */
			page = command.execute(request);
			// ����� ���������� �������� ������
			// page = null; // ��������������������!
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
				// ����� �������� ������ �� ������
				dispatcher.forward(request, response);
			
	}

}
