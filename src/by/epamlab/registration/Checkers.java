package by.epamlab.registration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checkers {

	public static boolean checkLength(String s) {
		 return s.length()>=5;
	}
	
	public static boolean checkSymbols(String s) {
		final String PASSWORD_PATTERN = "^[a-zA-Z0-9_.,@%\\$]*$";
		final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(s);
		return matcher.matches();
		
	}
}
