package servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.billydev.meb.database.EbConnectionProvider;



public class UserTypeSO implements UserType {

	private static UserTypeSO m_instance = null;
	
	
	  public static UserTypeSO getInstance() {
		    if (m_instance == null) {
		      m_instance = new UserTypeSO();
		    }
		    return m_instance;
		  }
	
	public UserTypeSO() {
       
	}

	@Override
	public String getHomePage(int iUserType) throws Exception {

		Connection conn=EbConnectionProvider.get_connection();
		
		PreparedStatement s=null;

		s = conn.prepareStatement("SELECT homepage FROM usertype  where usertype= ?");

		s.setInt(1, iUserType); 
		
		ResultSet rs=null; 
		

		rs=s.executeQuery(); 
		
        if(rs.next()){
             return rs.getString("Homepage");
        }
		
		conn.close();
		return "SignOnCtlr"; 
	}

	@Override
	public String getLongDesc(int iUserType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getShortDesc(int iUserType) {
		// TODO Auto-generated method stub
		return null;
	}

}
