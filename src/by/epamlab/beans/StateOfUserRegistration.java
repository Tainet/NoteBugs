package by.epamlab.beans;

public enum StateOfUserRegistration {
	OK(""),
	WRONG_FIRST_NAME("Error in field: First name"),
	WRONG_LAST_NAME("Error in field: Last name"),
	WRONG_EMAIL("Error in field: email"),
	WRONG_PASSWORD("Error in field: password"),
	PASSWORD_DOES_NOT_MATH("Error: Strings in field Password and Password confirmation must be the same"),
	STRING_TOO_SMALL("Error: String must be at least 5 characters length"),
	WRONG_CHARACTERS("Error: Accepted only latin letter, numbers and chars @, %, $"),
	GENERAL_ERROR("Error: Some error happens. Cannot create user") ;
	
	private final String stateDescription;
	
	private  StateOfUserRegistration(String value) {
		stateDescription = value;
    }
	
	public String getStateOfUserRegistrationDescription() {
        return stateDescription;
    }
}
