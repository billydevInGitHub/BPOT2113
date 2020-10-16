package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public abstract class AllServlet extends HttpServlet {

	protected  static final String JSP_TEMPLATE_PAGE ="/jsps/com/billydev/meb/security/pages/Template.jsp"; 

	
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
    	//get the controller name 
        String className = this.getClass().getName();
        String servletName = className.substring(className.lastIndexOf(".") + 1);
        SessionDataManager sdm = null;

        AllRequest allRequest = new AllRequest(request);
        AllResponse allResponse = new AllResponse(response);

     try {
      	if(servletName.equals("SignOnCtlr")){
      		// might check the signon data for multiple login user 
    		allRequest.getSession().invalidate();
    		myservice(allRequest, allResponse); 
    	} else{
    		
    		if(allRequest.getSessionDataManagerInSession()!=null&&(0!=allRequest.getSessionDataManager().getUserManager().getCurrentUser().getUserType()))
            {
            	//already login user(not a guest user), then just go to the controller logic      
    				myservice(allRequest, allResponse);

            }else{
            	// reach the controller other than SignOnCtlr, but no sdm in session
            	// redirect to SignOnCtlr 
        		allResponse.sendRedirect("SignOnCtlr");	
            }

    	}
    	 
        
     } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
     }
     
     
        
    }
	
	protected abstract void myservice(AllRequest allRequest, AllResponse allResponse) throws Exception;
	
	
}
