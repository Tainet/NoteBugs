package by.epamlab.beans;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoleTest {

	@Test
	public void testGetInstanceNull() {
		Role test = Role.getInstance(null);
		assertEquals(Role.GUEST,test);
	}
	
	@Test
	public void testGetInstanceAny() {
		Role test = Role.getInstance("abra");
		assertEquals(Role.GUEST,test);
	}

	@Test
	public void testGetInstanceAdmin() {
		Role test = Role.getInstance("administrator");
		assertEquals(Role.ADMINISTRATOR,test);
	}
	@Test
	public void testGetInstanceUser() {
		Role test = Role.getInstance("user");
		assertEquals(Role.USER,test);
	}
}
