package by.epamlab.command;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epamlab.beans.User;
import by.epamlab.controller.ActionCommand;
import by.epamlab.dao.DAOIteratorImpl;
import by.epamlab.dao.IteratorDAO;

public class UsersListPageCommand implements ActionCommand {
	private static final int NUMBER_OF_ROWS = 3;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		
		session.setAttribute("previousPage", "false");
		session.setAttribute("nextPage", "false");
		String sort = request.getParameter("sort");
//		TODO set attributes for link in page e.g. sort = firstname_asc
		
		Integer pageNumber = (Integer) session.getAttribute("pageNumber");
		int pageN = (pageNumber==null)? 0: pageNumber;

		
		IteratorDAO iterator = new DAOIteratorImpl(NUMBER_OF_ROWS);
		iterator.setSort(sort);
        List<User> usersList = new ArrayList<User>();
        
        while(iterator.hasNext() & iterator.nextIndex() < pageN){
        	//side effect from  .nextIndex()
        }
        iterator.previousIndex();
        if(iterator.hasNext()){
        	usersList=iterator.next();
        	iterator.previousIndex();//side effect from  .next()
        }
        

        if(iterator.hasPrevious()){
        	session.setAttribute("previousPage", "true");
        }
        iterator.nextIndex();//side effect from  .previousIndex()
        if(iterator.hasNext()){
        	session.setAttribute("nextPage", "true");
        }
		
        session.setAttribute("usersList", usersList);
		session.setAttribute("sort", iterator.getSort());
		session.setAttribute("direction", iterator.getDirection());
		
		String page = "/WEB-INF/jsp/userslist.jsp";
		return page;
	}
}
