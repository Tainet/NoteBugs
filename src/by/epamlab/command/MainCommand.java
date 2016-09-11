package by.epamlab.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epamlab.beans.Role;
import by.epamlab.beans.User;
import by.epamlab.controller.ActionCommand;


public class MainCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession(true);
		User user = (User) session.getAttribute("user");
		if(user==null){
			user = User.getGuest();
			session.setAttribute("user", user);
		}

//		getIssue();
		
//		TODO
//		1. If not exist - create new Session +++
//		2. For new Session set Role to GUEST +++ will set to GUEST by default
//		3. If user already login - get issueList from DAO
//		3. else get last N record from DAO
		return "/WEB-INF/jsp/main.jsp";
	}

	private void getIssue() {
		throw new UnsupportedOperationException();
	}

}
