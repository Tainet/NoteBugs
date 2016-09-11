

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import by.epamlab.beans.RoleTest;
import by.epamlab.registration.CheckersTest;
import by.epamlab.registration.PasswordValidatorTest;
import by.epamlab.registration.TextValidatorTest;

@RunWith(Suite.class)
@SuiteClasses({RoleTest.class, CheckersTest.class, PasswordValidatorTest.class, TextValidatorTest.class })
public class AllTests {

}
