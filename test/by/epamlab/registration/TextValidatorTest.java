package by.epamlab.registration;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextValidatorTest {

	@Test
	public void testValidate() {
		TextValidator test = new TextValidator();
		test.setFieldName("Name");
		test.setFieldValue("12345");
		assertEquals(true, test.validate());
	}
	
	@Test
	public void testValidateNot() {
		TextValidator test = new TextValidator();
		test.setFieldName("Name");
		test.setFieldValue("1234");
		assertEquals(false, test.validate());
	}
	@Test
	public void testValidateBadChar() {
		TextValidator test = new TextValidator();
		test.setFieldName("Name");
		test.setFieldValue("~~~~~~~");
		assertEquals(false, test.validate());
	}

}
