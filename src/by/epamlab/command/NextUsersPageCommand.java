package by.epamlab.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epamlab.controller.ActionCommand;

public class NextUsersPageCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "/controller?command=users_list_page";
		HttpSession session=request.getSession();
		Integer pageNumber = (Integer) session.getAttribute("pageNumber");
		int pageN = (pageNumber==null)?0:pageNumber;
		pageNumber = ++pageN;
		session.setAttribute("pageNumber",pageNumber);
		return page;
	}
}
