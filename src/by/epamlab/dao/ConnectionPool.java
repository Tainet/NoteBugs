package by.epamlab.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {
	private Connection connection;
	
	public ConnectionPool() {
		Context initContext;
		try {
			initContext = new InitialContext();
		    Context envContext = (Context) initContext.lookup("java:comp/env");
		    DataSource ds = (DataSource) envContext.lookup("jdbc/NoteBug");
		    connection = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection(){
		return this.connection;
	}
	
	public void close(){
		if(this.connection != null){
			try {
				this.connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
