package servlets;

import java.io.Serializable;




public class SessionDataManager implements Serializable {
	
	private SignOnData m_objSignOnData; 
	private UserManagerSO m_objUserManager;
	private PageData m_pageData;
	
	public SessionDataManager() {
		// initiate a user manager object
		m_objUserManager = new UserManagerSO();
	//	sessionObj = new Hashtable();
	}

	public SignOnData getSignOnData() {
		return m_objSignOnData;
	}

	public UserManager getUserManager() {
		return (UserManager)m_objUserManager;
	}

	public PageData getPageData() {
		// TODO Auto-generated method stub
		return m_pageData ;
	}

	public void setPageData(PageData pageData) {
		// TODO Auto-generated method stub
		m_pageData=pageData; 
	}



//	private UserManagerSO m_objUserManager;
	
//	public UserManager getUserManager() {
//		return (UserManager)m_objUserManager;
//	}
}
