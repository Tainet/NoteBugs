package by.epamlab.beans;

public class UserDataForRegistration {
	private User user;
	private String password;
	private String passwordConfirmation;
	
	
	public UserDataForRegistration(User user, String password, String passwordConfirmation) {
		this.user = user;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
}
