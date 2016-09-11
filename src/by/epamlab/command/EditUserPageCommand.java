package by.epamlab.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epamlab.beans.User;
import by.epamlab.controller.ActionCommand;
import by.epamlab.dao.FabricUserDAO;
import by.epamlab.dao.UserDAO;

public class EditUserPageCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "/WEB-INF/jsp/edit_user.jsp";
		
		String email = request.getParameter("email");
		
		
		HttpSession session=request.getSession(true);
		session.setAttribute("oldEmail", email);
		
		UserDAO userDAO = FabricUserDAO.getInstance();
		User user = userDAO.readUser(email);
		session.setAttribute("editUser", user);
		
		return page;
	}
}
