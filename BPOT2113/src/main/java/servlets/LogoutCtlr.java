package servlets;

import java.util.Enumeration;

public class LogoutCtlr extends AllServlet {

	@Override
	protected void myservice(AllRequest allRequest, AllResponse allResponse)
			throws Exception {
		// TODO Auto-generated method stub
		SessionDataManager sdm = allRequest.getSessionDataManager();
		  Enumeration sessionVars = allRequest.getSession().getAttributeNames();
		    while (sessionVars.hasMoreElements()) {
		      // number of session vars found
		      // go through all session vars, calling removeValue() on each
		      String strNextVarName = (String)sessionVars.nextElement();
		      if (strNextVarName.compareTo("ActiveSessionTimeStamp") != 0) {
		    	  allRequest.getSession().removeAttribute(strNextVarName);
		      }
		    }

		    allRequest.putSessionDataManager(sdm);

		    UserManagerSO objUserManager = (UserManagerSO)sdm.getUserManager();
		    objUserManager.logout();


		    String  strSignOnPage = objUserManager.getCurrentUser().getHomePage();


		    allResponse.sendRedirect(strSignOnPage);
	}

	
}
