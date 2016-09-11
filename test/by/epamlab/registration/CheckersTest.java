package by.epamlab.registration;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckersTest {

	@Test
	public void testCheckLengthZeroLength() {
		
		assertEquals(false, Checkers.checkLength(""));
	}
	@Test
	public void testCheckLengthOk() {
		
		assertEquals(true, Checkers.checkLength("12345"));
	}
	@Test
	public void testCheckSymbols() {
		
		assertEquals(true, Checkers.checkSymbols("good"));
	}
	
	@Test
	public void testCheckSymbolsNot() {
		
		assertEquals(false, Checkers.checkSymbols("`` ||ôû"));
	}

}
