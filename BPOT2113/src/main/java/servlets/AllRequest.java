package servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;





public class AllRequest {

	HttpServletRequest request;
	private final String SDM_NAME = "SessionDataManager";

	public AllRequest(HttpServletRequest req) {
	    request = req;
	}

	public HttpSession getSession() {
		return request.getSession(true);
	}

	public SessionDataManager getSessionDataManager() {
	    HttpSession session = getSession();
	    SessionDataManager sdm = (SessionDataManager)session.getAttribute(SDM_NAME);
	    if (sdm == null) {
	      sdm = new SessionDataManager();
	      session.setAttribute(SDM_NAME, sdm);
	    }
	    return sdm;
	}

	public SessionDataManager getSessionDataManagerInSession() {
		return (SessionDataManager) getSession().getAttribute(SDM_NAME);
	}

	public boolean putSessionDataManager(SessionDataManager sdm) {
		// TODO Auto-generated method stub
	    if (sdm != null) {
	        getSession().setAttribute(SDM_NAME, sdm);
	        return true;
	      }
	      return false;
	}
	
	
}
