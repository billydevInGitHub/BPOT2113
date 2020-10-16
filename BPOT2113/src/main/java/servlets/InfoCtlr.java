package servlets;

public class InfoCtlr extends AllServlet {

	private  static final String JSP_INFO_PAGE = "/jsps/com/billydev/meb/security/pages/InfoPage.jsp";
	
	@Override
	protected void myservice(AllRequest allRequest,
			AllResponse allResponse) throws Exception {
		//prepare the page data and redirect to the template 
	    SessionDataManager sdm = allRequest.getSessionDataManager();
	    User objUser = sdm.getUserManager().getCurrentUser();	
	    
	    PageData pageData = sdm.getPageData();
	    if (pageData == null) {
	      pageData = new PageData(objUser, JSP_INFO_PAGE);
	      sdm.setPageData(pageData);    }
		
	    pageData.putValue("userID",objUser.getUserID());
	    		
		this.getServletContext().getRequestDispatcher(JSP_TEMPLATE_PAGE).forward(allRequest.request,  allResponse.response);
	}

}
