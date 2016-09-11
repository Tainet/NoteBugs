package by.epamlab.registration;

import java.util.HashMap;
import java.util.Map;

import by.epamlab.beans.User;

public class UserEditValidator {
	private String firstName;
	private String lastName;
	private String email;
	private Map<String, String> result = new HashMap<String, String>();
	private TextValidator textValidator = new TextValidator();
	
	public UserEditValidator(){

	}
	
	public Map<String, String> check(User user) {
		
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		
		textValidator.setFieldName("First Name");
		textValidator.setFieldValue(firstName);
		validateText();
		textValidator.setFieldName("Last Name");
		textValidator.setFieldValue(lastName);
		validateText();
		textValidator.setFieldName("Email");
		textValidator.setFieldValue(email);
		validateText();
		
		return result;
	}
	
	private void validateText(){
		if(!textValidator.validate()){
			result.put(textValidator.getFieldName(), textValidator.getResultDescription());
		}
	}
}
