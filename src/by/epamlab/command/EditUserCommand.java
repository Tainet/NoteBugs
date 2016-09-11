package by.epamlab.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epamlab.beans.Role;
import by.epamlab.beans.StateOfUserRegistration;
import by.epamlab.beans.User;
import by.epamlab.beans.UserDataForRegistration;
import by.epamlab.controller.ActionCommand;
import by.epamlab.dao.FabricUserDAO;
import by.epamlab.dao.UserDAO;
import by.epamlab.registration.CheckUserDataForRegistration;
import by.epamlab.registration.UserEditValidator;
import by.epamlab.registration.UserRegistrationValidator;

import static by.epamlab.error.PageErrorMessage.setErrorMessage;

import java.util.HashMap;
import java.util.Map;

public class EditUserCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "/WEB-INF/jsp/edit_user.jsp";
		
		HttpSession session=request.getSession();
		String oldEmail =  (String) session.getAttribute("oldEmail");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String userRole = request.getParameter("role");
		Role role = Role.getInstance(userRole);
		User user = User.getInstance(firstName, lastName, email, role);
		
		UserDAO userDAO = FabricUserDAO.getInstance();
		
		Map<String, String> result = new HashMap<String, String>();
		UserEditValidator validator = new UserEditValidator();
		result = validator.check(user);
		if(result.size() == 0){
			if(userDAO.updateUser(user, oldEmail)){
				page = "/WEB-INF/jsp/edit_user_complete.jsp";
				return page;
			}else{
				setErrorMessage(request, StateOfUserRegistration.GENERAL_ERROR.getStateOfUserRegistrationDescription());
				return page;
			}	
		}else{
			session.setAttribute("errorFields", result);
			return page;
		}
		
	}
}
