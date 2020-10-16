package servlets;

import java.sql.SQLException;

public interface UserType {

	public String getHomePage(int iUserType) throws SQLException, Exception, IllegalAccessException, ClassNotFoundException;
	
	public String getLongDesc(int iUserType);

	public String getShortDesc(int iUserType);
	
	public final static int GUEST_USER = 0;
	
	public final static int SYS_USER = 1;    //developer maintenance 
	
	public final static int ADMIN_USER = 2;  //customer tech admin 
	
	public final static int MANAGER_USER = 3; 
	
	public final static int NORMAL_USER = 4;
	
}
