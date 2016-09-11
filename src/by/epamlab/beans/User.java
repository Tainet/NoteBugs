package by.epamlab.beans;

import java.io.Serializable;

public final class User implements Serializable {
	private static final long serialVersionUID = -8426830681665983438L;
	private final String firstName;
	private final String lastName;
	private final String email;
	private final Role role;
	
	private User(String firstName, String lastName, String email, Role role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}
	
	public static User getInstance(String firstName, String lastName, String email, Role role){
		return new User(firstName, lastName, email, role);
	}
	
	public static User getGuest(){
		return new User("Guest", "Guest", "Guest", Role.GUEST);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public Role getRole() {
		return role;
	}
	
}
