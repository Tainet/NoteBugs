package by.epamlab.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import by.epamlab.beans.Role;
import by.epamlab.beans.User;
import by.epamlab.beans.UserDataForRegistration;

public class TestDAOImpl implements UserDAO {

	@Override
	public boolean createUser(UserDataForRegistration userDataForRegistration) {
		ConnectionPool connectionPool = new ConnectionPool();
		try {
            Connection conn = connectionPool.getConnection();
            
            String firstName = userDataForRegistration.getUser().getFirstName(); 
            String lastName = userDataForRegistration.getUser().getLastName();
            String email = userDataForRegistration.getUser().getEmail();
            String role = userDataForRegistration.getUser().getRole().toString();
            String password = userDataForRegistration.getPassword();
            
            String sql = "insert into user values(NULL,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, email);
			ps.setString(4, role);
			ps.setString(5, password);
			
            int result = ps.executeUpdate();
            
            ps.close();
            conn.close();
            
            if(result>0){
				return true;
			}
            
        } catch (SQLException e) {
        	e.printStackTrace();
        }finally{
        	connectionPool.close();
        }
		

		return false;
	}

	@Override
	public User readUser(String email) {
		User user = User.getGuest();		
		ConnectionPool connectionPool = new ConnectionPool();
		
		try{
	        Connection conn = connectionPool.getConnection();
			
	        String sql = "select firstname, lastname, role from user where email = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, email);
			
			ResultSet resultSet = ps.executeQuery();
	        boolean userExist = resultSet.next();
	        
			if(userExist){
				String firstName = resultSet.getString("firstname");
				String lastName=resultSet.getString("lastname");
				String roleString=resultSet.getString("role");
				Role role=Role.getInstance(roleString);
				user=User.getInstance(firstName, lastName, email, role);
			}
			
			ps.close();
            conn.close();
            
        } catch (SQLException e) {
        	e.printStackTrace();
        }finally{
        	connectionPool.close();
        }
		

		return user;
	}

	@Override
	public boolean updateUser(User user, String oldEmail) {
		ConnectionPool connectionPool = new ConnectionPool();
		
		String newEmail = user.getEmail();
		if (newEmail.equals(oldEmail)){
			try {
	            Connection conn = connectionPool.getConnection();
	            String firstName = user.getFirstName(); 
	            String lastName = user.getLastName();
	            String role = user.getRole().toString();
	            String email = user.getEmail();
	            
	            String sql = "update user set firstname = ?, lastname = ?, role = ? where email = ?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            
	            ps.setString(1, firstName);
				ps.setString(2, lastName);
				ps.setString(3, role);
				ps.setString(4, email);
				
	            int result = ps.executeUpdate();
	            
	            ps.close();
	            conn.close();
	            
	            if(result>0){
					return true;
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}else{
			String password = getPassword(oldEmail);
			UserDataForRegistration userDataForRegistration = new UserDataForRegistration(user, password, password);
			if(createUser(userDataForRegistration)){
				if(deleteUser(oldEmail)){
					return true;
				}
			}
		}
		return false;
	}

	
	@Override
	public boolean deleteUser(String email) {
		
		ConnectionPool connectionPool = new ConnectionPool();
		try {
            Connection conn = connectionPool.getConnection();
          
            String sql = "delete from user where email = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
 			ps.setString(1, email);
			
            int result = ps.executeUpdate();
            
            ps.close();
            conn.close();
            
            if(result>0){
				return true;
			}
            
        } catch (SQLException e) {
        	e.printStackTrace();
        }finally{
        	connectionPool.close();
        }
		return false;
	}
	
	@Override
	public boolean checkPassword(User user, String password){
		ConnectionPool connectionPool = new ConnectionPool();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		
		try{
	        Connection conn = connectionPool.getConnection();
			
	        String sql = "select password from user where email = ?";
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, user.getEmail());
			
			resultSet = ps.executeQuery();
	        boolean userExist = resultSet.next();
	        
	        
			if(userExist){
				String realPassword = resultSet.getString("password");
				if(realPassword.equals(password)){
					return true;
				}
			}
			
			conn.close();
			
            return false;
            
        } catch (SQLException e) {
        	e.printStackTrace();
        }finally{
        	try {
        		ps.close();
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	connectionPool.close();
        }
		return false;
	}
	
	@Override
	public boolean updatePassword(String email, String newPassword){
		ConnectionPool connectionPool = new ConnectionPool();
		Connection conn = null;
		PreparedStatement ps = null;
		try{
	        conn = connectionPool.getConnection();
			
	        String sql = "update user set password = ? where email = ?";
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, newPassword);
	        ps.setString(2, email);
	        int result = ps.executeUpdate();
            
            if(result>0){
				return true;
			}
        } catch (SQLException e) {
        	e.printStackTrace();
        }finally{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	connectionPool.close();
        }
		return false;
	}

	private String getPassword(String oldEmail) {
		ConnectionPool connectionPool = new ConnectionPool();
		String password = null;
		try{
	        Connection conn = connectionPool.getConnection();
			
	        String sql = "select password from user where email = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, oldEmail);
			
			ResultSet resultSet = ps.executeQuery();
	        boolean userExist = resultSet.next();
	        
			if(userExist){
				password = resultSet.getString("password");
			}
			
			ps.close();
            conn.close();
            
        } catch (SQLException e) {
        	e.printStackTrace();
        }finally{
        	connectionPool.close();
        }
		return password;
	}

}
