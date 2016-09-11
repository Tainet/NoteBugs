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

public class RegistrationCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "/WEB-INF/jsp/registration.jsp";
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
		
		CheckUserDataForRegistration checkUserDataForRegistration = new CheckUserDataForRegistration();
		StateOfUserRegistration state = checkUserDataForRegistration.check(userDataForRegistration);
		
		if(state==StateOfUserRegistration.OK){
			UserDAO userDAO = FabricUserDAO.getInstance();
			
			if(userDAO.createUser(userDataForRegistration)){
				page = "/WEB-INF/jsp/registration_complete.jsp";
				return page;
			}else{
				state=StateOfUserRegistration.GENERAL_ERROR;
				setErrorMessage(request, state.getStateOfUserRegistrationDescription());
				return page;
			}
		}else{
//			TODO return all field content
			setErrorMessage(request, state.getStateOfUserRegistrationDescription());
			return page;
		}

//		TODO Check if admin.
//		TODO to static method
//		HttpSession session=request.getSession(true);

	}
}
