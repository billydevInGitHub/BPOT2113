package servlets;

import javax.servlet.http.HttpServletResponse;

public class AllResponse {

    HttpServletResponse response;

	public AllResponse(HttpServletResponse res) {
        response = res;
    }
	
    public void sendRedirect(String strModule) throws Exception {
        response.sendRedirect(strModule);
    }
}
