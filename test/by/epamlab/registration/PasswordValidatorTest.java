package by.epamlab.registration;

import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordValidatorTest {

	@Test
	public void testValidate() {
		PasswordValidator test = new PasswordValidator();
		test.setFieldName("password");
		test.setFieldValue("password");
		test.setSecondFieldValue("password");
		assertEquals(true, test.validate());
	}
	
	@Test
	public void testValidateNot() {
		PasswordValidator test = new PasswordValidator();
		test.setFieldName("password");
		test.setFieldValue("password");
		test.setSecondFieldValue("pass");
		assertEquals(false, test.validate());
	}
}
