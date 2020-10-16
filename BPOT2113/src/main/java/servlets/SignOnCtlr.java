package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/SignOnCtlr")
public class SignOnCtlr extends AllServlet {

	private  static final String JSP_SIGNON_PAGE = "/jsps/com/billydev/meb/security/pages/SignOnPage.jsp";
	
	@Override
	protected void myservice(AllRequest request, AllResponse response)
			throws Exception {


	    SessionDataManager sdm = request.getSessionDataManager();
	    User objUser = sdm.getUserManager().getCurrentUser();	    
	    
	
		String strUserID = request.request.getParameter("UserId");
		
	    PageData pageData = sdm.getPageData();
	    if (pageData == null) {
	      pageData = new PageData(objUser, JSP_SIGNON_PAGE);
	    }
		
	    SignOnBO bo = new SignOnBO();   
		System.out.println("Now reached signon controller");
	    
	    
		if("GET".equals(request.request.getMethod())) {
			//the first time redirect to the login page
		      pageData.putValue("pageName", SignOnBO.SIGNON_DEFAULT_URL);
		      sdm.setPageData(pageData);
			this.getServletContext().getRequestDispatcher(JSP_TEMPLATE_PAGE).forward(request.request,  response.response);
		} else if("POST".equals(request.request.getMethod())) {
		    bo.populateVariables(strUserID, request.request.getParameter("Password"));			
			bo.validateSignOn(objUser);
		      String strUrl = bo.getURL();
		      if (strUrl != SignOnBO.SIGNON_DEFAULT_URL) { 
		    	  response.sendRedirect(bo.getURL());
		    	  return;
		      }
		    
		      pageData.putValue("pageName", bo.getURL());
		      pageData.putValue("ErrMsg", bo.getErrMsg());
		      sdm.setPageData(pageData);
		    // when logon failure need to go the template URL ( which is jsp template) 
			this.getServletContext().getRequestDispatcher(JSP_TEMPLATE_PAGE).forward(request.request,  response.response);
		}		
       		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Enumeration e = request.getHeaderNames();
        
        
        
        
        out.println("Billy15 This is a test servlet!<br><br><br>");
        while (e.hasMoreElements()) {
            String name = (String)e.nextElement();
            String value = request.getHeader(name);
            out.println(name + " = " + value);
        }
        
        
        getServletContext().getRequestDispatcher("/jsps/com/billydev/meb/security/pages/SignOnPage.jsp").forward(request,  response);
	}
/*	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
*/
}
