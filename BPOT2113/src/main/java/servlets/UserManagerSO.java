package servlets;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Stack;

public class UserManagerSO implements UserManager, Serializable {

	
	
	
	private Stack m_stackUsers;

	public UserManagerSO() {
	    m_stackUsers = new Stack();
	    m_stackUsers.push(new UserSO());
	}

	@Override
	public boolean assumeUser(String strUserID) throws IllegalAccessException, ClassNotFoundException, SQLException, Exception {
		boolean bSuccess=false; 
		// Prepare a new userSO
		User objCurrentUser=getCurrentUser(); 
		if(objCurrentUser.getUserType()==1||objCurrentUser.getUserType()==2){
			UserSO objAssumedUser =new UserSO(); 
			 bSuccess = objAssumedUser.assumeUser(strUserID);
			 objAssumedUser.setLocaleSelection(getRootUser().getLocaleSelection());
				if(bSuccess){
					objAssumedUser.setLocaleSelection(getRootUser().getLocaleSelection());
					m_stackUsers.push(objAssumedUser);
				}
		}	
		return bSuccess;
	}

	@Override
	public User getCurrentUser() {
		return (User)m_stackUsers.peek();
	}

	@Override
	public User getRootUser() {
		return (User)m_stackUsers.firstElement();
	}

	@Override
	public User getUser(int iLevel) {
	    ArrayList aUsers = new ArrayList(m_stackUsers);
	    if (iLevel >= 0 && iLevel < aUsers.size()) {
	      return (User)aUsers.get(iLevel);
	    }
	    return null;
	}

	@Override
	public int getNbrOfUsers() {
		return m_stackUsers.size();
	}

	@Override
	public String logon(String strUserID, String strPassword) throws Exception {
		    m_stackUsers = new Stack();
		    UserSO objUser = new UserSO();
		    String strLogonStatus = objUser.logon(strUserID, strPassword);
		    m_stackUsers.push(objUser);
		    return strLogonStatus;
	}

	@Override
	public void logout() throws Exception {
		// TODO Auto-generated method stub
        m_stackUsers.pop();
       if (m_stackUsers.isEmpty()) {
          m_stackUsers.push(new UserSO());
       }
	}

}
