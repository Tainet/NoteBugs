package by.epamlab.beans;

public enum Role {
	GUEST,
	USER,
	ADMINISTRATOR;

	public static Role getInstance(String role) {
		try {
			Role currentRole = Role.valueOf(role.toUpperCase());
			return currentRole;
		} catch (IllegalArgumentException | NullPointerException e) {
			return GUEST;
		}
	}
	
	@Override
	  public String toString() {
	   return super.toString().toLowerCase();
	  }
}
