package by.epamlab.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epamlab.controller.ActionCommand;

public class EditPasswordPageCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "/WEB-INF/jsp/edit_password.jsp";
		
		String email = request.getParameter("email");
		
		HttpSession session=request.getSession();
		session.setAttribute("email", email);
		
		return page;
	}
}
