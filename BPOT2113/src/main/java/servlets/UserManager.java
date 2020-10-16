package servlets;

import java.sql.SQLException;

public interface UserManager {

	public boolean assumeUser(String strUserID) throws IllegalAccessException, ClassNotFoundException, SQLException, Exception;
	
	public User getCurrentUser();
	
	public User getRootUser();

	public User getUser(int iLevel);

	public int getNbrOfUsers();

	public String logon(String strUserID, String strPassword) throws Exception;

	public void logout()             throws Exception;
	
}
