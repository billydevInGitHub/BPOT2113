package servlets;

public class ServiceEntryCtlr extends AllServlet {

	private  static final String JSP_SERVICEENTRY_PAGE = "/jsps/com/billydev/meb/security/pages/ServiceEntryPage.jsp";
	
	@Override
	protected void myservice(AllRequest allRequest, AllResponse allResponse)
			throws Exception {
		 SessionDataManager sdm = allRequest.getSessionDataManager();
		    User objUser = sdm.getUserManager().getCurrentUser();	
		    
		    PageData pageData  = new PageData(objUser, JSP_SERVICEENTRY_PAGE);
		      sdm.setPageData(pageData);  
			
		    pageData.putValue("userID",objUser.getUserID());
		    		
			this.getServletContext().getRequestDispatcher(JSP_TEMPLATE_PAGE).forward(allRequest.request,  allResponse.response);
		
	}

}
