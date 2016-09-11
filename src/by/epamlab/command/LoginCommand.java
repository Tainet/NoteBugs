package by.epamlab.command;

import static by.epamlab.error.PageErrorMessage.setErrorMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epamlab.beans.Role;
import by.epamlab.beans.User;
import by.epamlab.controller.ActionCommand;
import by.epamlab.dao.FabricUserDAO;
import by.epamlab.dao.UserDAO;

public class LoginCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDAO userDAO = FabricUserDAO.getInstance();
		User user = userDAO.readUser(email);
		
		
		if(user.getRole()==Role.GUEST){
			setErrorMessage(request, "You are guest!");
		}
		
		if(userDAO.checkPassword(user, password)){
			HttpSession session=request.getSession(true);
			session.setAttribute("user", user);
		}else{
			setErrorMessage(request, "Wrong password!");
		}
		
		
		return "/WEB-INF/jsp/main.jsp";
	}

}
