package by.epamlab.dao;

import by.epamlab.beans.User;
import by.epamlab.beans.UserDataForRegistration;

public interface UserDAO {
	boolean createUser(UserDataForRegistration userDataForRegistration);
	User readUser(String email);
	boolean updateUser(User user, String oldEmail);
	boolean deleteUser(String email);
	boolean checkPassword(User user, String password);
	boolean updatePassword(String email, String newPassword);
}
