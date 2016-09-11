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
import by.epamlab.registration.UserRegistrationValidator;

import static by.epamlab.error.PageErrorMessage.setErrorMessage;

import java.util.HashMap;
import java.util.Map;

public class Registration2Command implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "/WEB-INF/jsp/registration2.jsp";
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String userRole = request.getParameter("role");
		Role role = Role.getInstance(userRole);
		String password = request.getParameter("password");
		String passwordConfirmation = request.getParameter("passwordConfirmation");
		
		User user = User.getInstance(firstName, lastName, email, role);
		UserDataForRegistration userDataForRegistration =
				new UserDataForRegistration(user, password, passwordConfirmation);
		
		Map<String, String> result = new HashMap<String, String>();
		UserRegistrationValidator validator = new UserRegistrationValidator();
		result = validator.check(userDataForRegistration);
		
		if(result.size() == 0){
			UserDAO userDAO = FabricUserDAO.getInstance();
			
			if(userDAO.createUser(userDataForRegistration)){
				page = "/WEB-INF/jsp/registration_complete.jsp";
				return page;
			}else{
				setErrorMessage(request, StateOfUserRegistration.GENERAL_ERROR.getStateOfUserRegistrationDescription());
				return page;
			}
		}else{

			HttpSession session = request.getSession();
			session.setAttribute("errorFields", result);
			return page;
		}

	}
}
