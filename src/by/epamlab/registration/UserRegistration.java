package by.epamlab.registration;


import by.epamlab.beans.StateOfUserRegistration;
import by.epamlab.beans.UserDataForRegistration;
import by.epamlab.dao.FabricUserDAO;
import by.epamlab.dao.UserDAO;

public class UserRegistration {
	void register(UserDataForRegistration userDataForRegistration){
		try{
			CheckUserDataForRegistration checker = new CheckUserDataForRegistration();
			if(checker.check(userDataForRegistration)==StateOfUserRegistration.OK){
				UserDAO dao = FabricUserDAO.getInstance();
				dao.createUser(userDataForRegistration);
			}
		}
		catch(Exception e){
//			TODO probably SQLException will be there
		}
	}

}
