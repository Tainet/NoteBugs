package by.epamlab.error;

import javax.servlet.http.HttpServletRequest;

import by.epamlab.beans.StateOfUserRegistration;

public class PageErrorMessage {
	
	public static void setErrorMessage(HttpServletRequest request, String errorMessage){
		request.setAttribute("errorMessage", errorMessage);
	}
	
	public static void setErrorMessage(HttpServletRequest request, StateOfUserRegistration state){
		request.setAttribute("errorMessage", state);
	}

}
