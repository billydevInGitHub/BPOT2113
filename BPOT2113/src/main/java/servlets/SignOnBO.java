package servlets;

public class SignOnBO {

	public static String SIGNON_DEFAULT_URL = "/jsps/com/billydev/meb/security/pages/SignOnPage.jsp";
	private String m_strUserId;
	private String m_strPassword;
	private String m_strUrl;
	private String m_errMsg;

	public SignOnBO() {
		m_errMsg = "";
		m_strUrl = SIGNON_DEFAULT_URL;
	}

	public void populateVariables(String strUserId, String strPassword) {
		m_strUserId = strUserId.trim();
		m_strPassword = strPassword;

		// Log.write(Log.INFO, "Previous UserID = " + strPrevUserId +
		// ", current UserID = " + m_strUserId + ".");
		// Log.write(Log.INFO, "Number of previous attempts = " +
		// m_iNoofAttempts);

	}

	public void validateSignOn(User user) throws Exception {

		String errMsg = user.logon(m_strUserId, m_strPassword);

		if (errMsg == null) {
		    m_strUrl = user.getHomePage();
		} else {
			m_errMsg = errMsg;
	    }
	}

	public String getErrMsg() {
		return m_errMsg;
	}

	public String getURL() {
		return m_strUrl;
	}

}
