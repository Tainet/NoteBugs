package by.epamlab.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epamlab.controller.ActionCommand;

public class LogoutCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession(true);
		session.invalidate();
		
		return "/WEB-INF/jsp/main.jsp";
	}

}
