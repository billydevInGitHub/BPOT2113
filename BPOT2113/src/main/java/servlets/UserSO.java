package servlets;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.billydev.meb.database.EbConnectionProvider;

public class UserSO implements User {
	
	private final static String INVALID_PASSWORD_MSG = "Invalid Password!";
	
	private int m_iUserType;
	private String m_strUserID; 
	private LocaleInterface m_objLocaleItem =  new LocaleItem(); //finally need to come from the manager 

	public UserSO() {
		
		m_iUserType = UserType.GUEST_USER;
	
	}

	
	@Override
	public String logon(String strUserID, String strPassword) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		Connection conn=EbConnectionProvider.get_connection();
		
		PreparedStatement s=null;

		s = conn.prepareStatement("SELECT usertype,  userid  FROM signon where userid= ?");

		s.setString(1,strUserID); 
		
		ResultSet rs=null; 
		

		rs=s.executeQuery(); 
		
        if(rs.next()){
        	m_iUserType=rs.getInt("USERTYPE");
			m_strUserID=rs.getString("UserID"); 
        } else{
        	return INVALID_PASSWORD_MSG; 
        }
		
		conn.close();
		
		return null;//means login successfully
	}

	@Override
	public String getEmailID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserID() {
		// test cvs stuff 
		return m_strUserID;
	}

	@Override
	public int getUserType() {
		// TODO Auto-generated method stub
		return m_iUserType;
	}

	@Override
	public String getHomePage() throws  Exception {
		return UserTypeSO.getInstance().getHomePage(m_iUserType);
	}


	public boolean assumeUser(String strUserID) throws Exception, IllegalAccessException, ClassNotFoundException, SQLException {
		//Here we get all the imformation from db
		
      Connection conn=EbConnectionProvider.get_connection();
		
		PreparedStatement s=null;

		s = conn.prepareStatement("SELECT usertype,  userid  FROM signon where userid= ?");

		s.setString(1,strUserID); 
		
		ResultSet rs=null; 
		

		rs=s.executeQuery(); 
		
        if(rs.next()){
        	m_iUserType=rs.getInt("USERTYPE");
			m_strUserID=rs.getString("UserID"); 
        } else{
        	return false;// suppose this shall not happen 
        }
		
		conn.close();
		
	    return true; 
	}


	@Override
	public LocaleInterface getLocaleSelection() {
		
		return m_objLocaleItem; 
	}


	public void setLocaleSelection(LocaleInterface localeSelection) {
		m_objLocaleItem=localeSelection; 
		
	}

}
