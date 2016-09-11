package by.epamlab.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epamlab.beans.CommandEnum;

public class ActionFactory {
	private ActionCommand actionCommand;
	private CommandEnum currentEnum;

	public ActionFactory() {
	}

	public ActionCommand defineCommand(HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("command");
		try {
			currentEnum = CommandEnum.valueOf(action.toUpperCase());
			actionCommand = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
//			TODO return error page
			throw new NoSuchMethodError("There is no command for Servlet: " + action);
		}
		return actionCommand;
	}

}
