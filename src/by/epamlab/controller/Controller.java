package by.epamlab.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/controller")
public class Controller extends HttpServlet {
	private ActionFactory actionFactory = new ActionFactory();
	private ActionCommand command;
	private RequestDispatcher dispatcher;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		command = actionFactory.defineCommand(request, response);
		String page = command.execute(request, response);
System.out.println("From Controller line 30. Page = " + page);
		dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
}
