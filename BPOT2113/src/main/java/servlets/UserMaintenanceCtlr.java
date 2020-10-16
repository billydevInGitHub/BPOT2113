package servlets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.billydev.meb.database.EbConnectionProvider;

public class UserMaintenanceCtlr extends AllServlet {

	private  static final String JSP_USER_SEARCH_PAGE = "/jsps/com/billydev/meb/security/pages/UserSearchPage.jsp";

	
	@Override
	protected void myservice(AllRequest allRequest, AllResponse allResponse)
			throws Exception {
		 SessionDataManager sdm = allRequest.getSessionDataManager();
		    User objUser = sdm.getUserManager().getCurrentUser();	
		    
		    PageData pageData = sdm.getPageData();
		    
		    // controller common variables 
		    int case_num=0; 
		    StringBuilder pageContent=new StringBuilder(); 
		    
		    
		    // controller logic
		    if(allRequest.request.getParameter("USER_ID")!=null){
		    	case_num=1; 
		    } else if (("assume_user".equals(allRequest.request.getParameter("ACTION")))&&(allRequest.request.getParameter("Assume_userid"))!=null){
		    	case_num=2; 
		    }
		    
		    
		    // controller transfer to the view 
		    switch(case_num){
		    case 1:  //display user information page
		    	pageData = new PageData(objUser, JSP_USER_SEARCH_PAGE);
			    sdm.setPageData(pageData);         
			    pageData.putValue("userID",objUser.getUserID());
			    pageContent.append("This is user information page<br><br>");		    
			    //get all user directly here from database			    
			    pageContent.append(get_user_information(allRequest.request.getParameter("USER_ID"))); 
			    pageData.putValue("allUsers", pageContent.toString());			    		
				this.getServletContext().getRequestDispatcher(JSP_TEMPLATE_PAGE).forward(allRequest.request,  allResponse.response);
		    	break;
		    case 2:  //assume user 
		    	((UserManagerSO)sdm.getUserManager()).assumeUser(allRequest.request.getParameter("Assume_userid"));
		    	pageData = new PageData(objUser, JSP_USER_SEARCH_PAGE);
			    sdm.setPageData(pageData);         
			    pageData.putValue("userID",objUser.getUserID());
			    pageContent.append("This is user assume info page<br><br>");		    
			    //get all user directly here from database		
			    
			    pageContent.append(get_assuming_info(((UserManagerSO)sdm.getUserManager()).getCurrentUser().getHomePage(),((UserManagerSO)sdm.getUserManager()).getCurrentUser().getUserID() )); 
			    pageData.putValue("allUsers", pageContent.toString());			    		
				this.getServletContext().getRequestDispatcher(JSP_TEMPLATE_PAGE).forward(allRequest.request,  allResponse.response);
		    	break;
		    default: 
		    	pageData = new PageData(objUser, JSP_USER_SEARCH_PAGE);
			    sdm.setPageData(pageData);         
			    pageData.putValue("userID",objUser.getUserID());	
			    pageContent.append("This is user search result page<br><br>");
			    //get all user directly here from database
			    pageContent.append(get_all_users()); 
			    pageData.putValue("allUsers", pageContent.toString());
			    		
				this.getServletContext().getRequestDispatcher(JSP_TEMPLATE_PAGE).forward(allRequest.request,  allResponse.response);	
		    	break; 
		    }
		    
		    
	
		
	}

	private String get_assuming_info(String homePage, String userId) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder("<br>");
		sb.append("We assuming "+userId+"<br>");
		sb.append("<br><a href='"+homePage+"'>confirm</a>");
		return sb.toString();
	}

	private String get_user_information(String userid) throws Exception, IllegalAccessException, ClassNotFoundException, SQLException {
		// Get user information for a specific user id 
		StringBuilder sb=new StringBuilder("<br>"); 
		Connection conn=EbConnectionProvider.get_connection();

		Statement s=null;

		s = conn.createStatement ();

		ResultSet rs=null; 

		rs=s.executeQuery ("SELECT *  FROM signon where userid='"+userid+"'");

		for(;rs.next();){
			sb.append("<br>userid="+rs.getString("userid")); 
			sb.append("<br>usertype="+Integer.toString(rs.getInt("usertype")) );
			sb.append("<br>firstname="+rs.getString("firstname")); 
			sb.append("<br>lastname="+rs.getString("lastname")); 
		}
		
		sb.append("<br><a href='UserMaintenanceCtlr?ACTION=assume_user&Assume_userid="+userid+"'>Assume</a>"); 
		
		conn.close();

		return sb.toString();
	}

	private String get_all_users() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		//get all users from the database
		StringBuilder sb=new StringBuilder("<br>"); 
		Connection conn=EbConnectionProvider.get_connection();

		Statement s=null;

		s = conn.createStatement ();

		ResultSet rs=null; 

		rs=s.executeQuery ("SELECT userid  FROM signon");

		for(;rs.next();){
			String userid=rs.getString("userid"); 
			sb.append("<a href=UserMaintenanceCtlr?USER_ID="+userid+">"+userid+"</a><br>");
		}
		
		conn.close();

		return sb.toString();
	}

}
