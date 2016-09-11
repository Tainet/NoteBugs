package by.epamlab.registration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import by.epamlab.beans.RoleTest;

@RunWith(Suite.class)
@SuiteClasses({RoleTest.class, CheckersTest.class, PasswordValidatorTest.class, TextValidatorTest.class })
public class AllTests {

}
