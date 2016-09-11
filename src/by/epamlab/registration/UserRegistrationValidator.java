package by.epamlab.registration;

import java.util.HashMap;
import java.util.Map;

import by.epamlab.beans.UserDataForRegistration;

public class UserRegistrationValidator {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String passwordConfirmation;
	private Map<String, String> result = new HashMap<String, String>();
	private TextValidator textValidator = new TextValidator();
	private PasswordValidator passwordValidator = new PasswordValidator();
	
	public UserRegistrationValidator(){

	}
	
	public Map<String, String> check(UserDataForRegistration userDataForRegistration) {
		
		this.firstName = userDataForRegistration.getUser().getFirstName();
		this.lastName = userDataForRegistration.getUser().getLastName();
		this.email = userDataForRegistration.getUser().getEmail();
		this.password = userDataForRegistration.getPassword();
		this.passwordConfirmation = userDataForRegistration.getPasswordConfirmation();
		
		
		textValidator.setFieldName("First Name");
		textValidator.setFieldValue(firstName);
		validateText();
		textValidator.setFieldName("Last Name");
		textValidator.setFieldValue(lastName);
		validateText();
		textValidator.setFieldName("Email");
		textValidator.setFieldValue(email);
		validateText();
		textValidator.setFieldName("Password");
		textValidator.setFieldValue(password);
		validateText();
		textValidator.setFieldName("Password Confirmation");
		textValidator.setFieldValue(passwordConfirmation);
		validateText();
		
		passwordValidator.setFieldName("Password");
		passwordValidator.setFieldValue(password);
		passwordValidator.setSecondFieldValue(passwordConfirmation);
		validatePassword();
		
		return result;
	}
	
	private void validateText(){
		if(!textValidator.validate()){
			result.put(textValidator.getFieldName(), textValidator.getResultDescription());
		}
	}
	
	private void validatePassword(){
		if(!passwordValidator.validate()){
			result.put(passwordValidator.getFieldName(), passwordValidator.getResultDescription());
		}
	}

}
