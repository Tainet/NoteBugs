package by.epamlab.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import by.epamlab.beans.Role;
import by.epamlab.beans.StateOfUserRegistration;
import by.epamlab.beans.User;
import by.epamlab.beans.UserDataForRegistration;
import by.epamlab.controller.ActionCommand;
import by.epamlab.dao.FabricUserDAO;
import by.epamlab.dao.UserDAO;
import by.epamlab.registration.CheckUserDataForRegistration;

import static by.epamlab.error.PageErrorMessage.setErrorMessage;

public class DeleteUserCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "/WEB-INF/jsp/main.jsp";
		
		String email = request.getParameter("email");

		UserDAO userDAO = FabricUserDAO.getInstance();
			
			if(userDAO.deleteUser(email)){
				page = "/WEB-INF/jsp/user_deleted.jsp";
				return page;
			}else{
				
				setErrorMessage(request, "cannot delete user");
				return page;
			}
	}
}
