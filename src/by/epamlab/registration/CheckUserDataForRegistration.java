package by.epamlab.registration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epamlab.beans.StateOfUserRegistration;
import by.epamlab.beans.UserDataForRegistration;

public class CheckUserDataForRegistration {
	private StateOfUserRegistration stateOfUserRegistration = StateOfUserRegistration.OK;
	
	public StateOfUserRegistration check(UserDataForRegistration userDataForRegistration) {
//		TODO chain pattern!!!
		checkFirstName(userDataForRegistration);
		checkLastName(userDataForRegistration);
		checkEmail(userDataForRegistration);
		checkPassword(userDataForRegistration);
		checkIfPairOfPasswordsTheSame(userDataForRegistration);
		return stateOfUserRegistration;

	}

	private void checkIfPairOfPasswordsTheSame(UserDataForRegistration userDataForRegistration) {
		String password=userDataForRegistration.getPassword();
		String passwordConfirmation=userDataForRegistration.getPasswordConfirmation();
		if(!password.equals(passwordConfirmation)){
			stateOfUserRegistration=StateOfUserRegistration.PASSWORD_DOES_NOT_MATH;
		}
	}

	private void checkPassword(UserDataForRegistration userDataForRegistration) {
		String password=userDataForRegistration.getPassword();
		checkLength(password);
		checkSymbols(password);
	}

	private void checkEmail(UserDataForRegistration userDataForRegistration) {
		String email=userDataForRegistration.getUser().getEmail();
		checkLength(email);
		checkSymbols(email);
//		TODO another check for @ symbol?
		
	}

	private void checkLastName(UserDataForRegistration userDataForRegistration) {
		String lastName=userDataForRegistration.getUser().getLastName();
		checkLength(lastName);
		checkSymbols(lastName);
		
	}

	private void checkFirstName(UserDataForRegistration userDataForRegistration) {
		String firstName=userDataForRegistration.getUser().getFirstName();
		checkLength(firstName);
		checkSymbols(firstName);
		
	}

	

	private void checkLength(String s) {
		 if(s.length()<5){
			 stateOfUserRegistration=StateOfUserRegistration.STRING_TOO_SMALL;
		 }
	}
	
	private void checkSymbols(String s) {
		final String PASSWORD_PATTERN = "^[a-zA-Z0-9_.,@%\\$]*$";
		final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(s);
		if(!matcher.matches()){
			stateOfUserRegistration=StateOfUserRegistration.WRONG_CHARACTERS;
		}
	}

}
