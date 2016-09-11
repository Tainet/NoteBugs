package by.epamlab.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epamlab.controller.ActionCommand;
import by.epamlab.dao.FabricUserDAO;
import by.epamlab.dao.UserDAO;
import by.epamlab.registration.PasswordEditValidator;
import static by.epamlab.error.PageErrorMessage.setErrorMessage;

import java.util.HashMap;
import java.util.Map;

public class EditPasswordCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "/WEB-INF/jsp/edit_password.jsp";
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordConfirmation = request.getParameter("passwordConfirmation");

		Map<String, String> result = new HashMap<String, String>();
		PasswordEditValidator validator = new PasswordEditValidator();
		result = validator.check(password, passwordConfirmation);
		
		UserDAO userDAO = FabricUserDAO.getInstance();
		
		if(result.size() == 0){
			if(userDAO.updatePassword(email, password)){
				page = "/WEB-INF/jsp/password_updated.jsp";
				return page;
			}else{
				setErrorMessage(request, "Cannot update password");
				return page;
			}
		}else{
			HttpSession session=request.getSession();
			session.setAttribute("errorFields", result);
			return page;
		}
			

	}
}
