package by.epamlab.registration;

import java.util.HashMap;
import java.util.Map;

public class PasswordEditValidator {
	private String password;
	private String passwordConfirmation;
	private Map<String, String> result = new HashMap<String, String>();
	private TextValidator textValidator = new TextValidator();
	private PasswordValidator passwordValidator = new PasswordValidator();
	
	public PasswordEditValidator(){

	}
	
	public Map<String, String> check(String password, String passwordConfirmation) {
		
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		
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
