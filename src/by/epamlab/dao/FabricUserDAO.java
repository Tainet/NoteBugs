package by.epamlab.dao;

public class FabricUserDAO {
	public static UserDAO getInstance(){
		return new TestDAOImpl();
	}

}
