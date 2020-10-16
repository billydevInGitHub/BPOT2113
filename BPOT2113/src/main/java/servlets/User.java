package servlets;

import java.sql.SQLException;

public interface User {

	 public String logon(String strUserID, String strPassword) throws Exception;
	
	 public String getEmailID();
	 
	 public String getUserID();
	 
	 public int getUserType();
	 
	 public String getHomePage() throws Exception;

	 public LocaleInterface getLocaleSelection();
	 
}
