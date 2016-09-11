package by.epamlab.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import by.epamlab.beans.Role;
import by.epamlab.beans.User;

public class DAOIteratorImpl implements IteratorDAO {
	private int actualPage;
    private int pageSize;
    private String sort = "firstname";
    private String direction ="asc";
    private List<User> userList = new ArrayList<User>();
    
    public DAOIteratorImpl(int pageSize) {
        this.actualPage = -1;
        this.pageSize = pageSize;
    }
    
    @Override
	public String getSort() {
		return sort;
	}

	@Override
	public String getDirection() {
		return direction;
	}
	
    @Override
    public void setSort(String sort2){
    	if(sort2==null){
    		sort2="";
    	}
    	switch(sort2){
    	case "firstname":
    	case "lastname":
    	case "email":
    	case "role":
    		this.sort = sort2;
    		this.direction = "asc";
    		break;
    	case "firstnamedesc":
    		this.sort = "firstname";
    		this.direction = "desc";
    		break;
    	case "lastnamedesc":
    		this.sort = "lastname";
    		this.direction = "desc";
    		break;
    	case "emaildesc":
    		this.sort = "email";
    		this.direction = "desc";
    		break;
    	case "roledesc":
    		this.sort = "role";
    		this.direction = "desc";
    		break;
    		
    	default:
    		this.sort = "firstname";
    		this.direction = "asc";
    	}
    	
    }
    
	@Override
	public boolean hasNext() {
		return actualPage < (getTotalPages()-1);
	}

	@Override
	public List<User> next() {
		return getPage(++actualPage);
	}

	@Override
	public boolean hasPrevious() {
		return actualPage >=0;
	}

	@Override
	public List<User> previous() {
		return getPage(--actualPage);
	}

	@Override
	public int nextIndex() {
		return ++actualPage;
	}

	@Override
	public int previousIndex() {
		return --actualPage;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void set(List<User> e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(List<User> e) {
		throw new UnsupportedOperationException();
	}
	
	private int getTotalPages() {
		ConnectionPool connectionPool = new ConnectionPool();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) as 'count' from user";
		int allRecords = 0;
		int pages = 0;
		try{
	        conn = connectionPool.getConnection();
	        ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();
	        if(rs.next()){
	        	allRecords = rs.getInt("count");
	        	pages = allRecords/pageSize;
	    		if(allRecords%pageSize == 0){
	    			return pages;
	    		}else{
	    			return ++pages;
	    		}
	        }
	        
            
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }finally{
        	try{
        	ps.close();
	        rs.close();
            conn.close();
        	}catch(SQLException e){
        		e.printStackTrace();
        	}
        }
		return pages;
	}
	
	private List<User> getPage(int i) {
		ConnectionPool connectionPool = new ConnectionPool();
        userList = new ArrayList<User>();
		try{
	        Connection conn = connectionPool.getConnection();
	        
	        
	        String sql = getSqlSort(sort,direction);
	        PreparedStatement ps = conn.prepareStatement(sql);

	        
	        int shift = i*pageSize;
	        ps.setInt(1, shift);
			ps.setInt(2, pageSize);
	        
	        ResultSet resultSet = ps.executeQuery();

	        while (resultSet.next()) {
	        	String firstName = resultSet.getString("firstname");
				String lastName=resultSet.getString("lastname");
				String roleString=resultSet.getString("role");
				String email=resultSet.getString("email");
				Role role=Role.getInstance(roleString);
				User user=User.getInstance(firstName, lastName, email, role);
	        	userList.add(user);
	        }
//		Use Decorator pattern! First sort table by criteria, then select.
//		Or Fabric: getSQL(sortingCriteria)! It return preparedStatement you need.
	        ps.close();
	        resultSet.close();
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }finally{
        	connectionPool.close();
        }
		return userList;
	}

	private String getSqlSort(String sort2, String direction2) {
		SqlBuilder builder = new SqlBuilder();
		builder.setField(sort2);
		builder.setDirection(direction);
		String sql=builder.build();
		
		return sql;
	}

	class SqlBuilder{
		String str = "select * from user order by ";
		String str2 = " ";
		String str3 = " limit ?, ? ";
		public void setField(String field){
			DAOIteratorImpl.this.sort=field; 
		}
		public void setDirection(String direction){
			DAOIteratorImpl.this.direction=direction; 
		}
		public String build(){
			return str+DAOIteratorImpl.this.sort+str2+DAOIteratorImpl.this.direction+str3; 
		}
	}

	
}
