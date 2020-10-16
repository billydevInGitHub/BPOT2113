<jsp:useBean id="SessionDataManager" scope="session" class="com.billydev.meb.security.servlets.SessionDataManager" />
<%
	com.billydev.meb.security.servlets.PageData pageData =SessionDataManager.getPageData();
	String userID=(String)pageData.getValue("userID");
%>	
 <table>
    <tr>
      <td colspan="4" align="left"></td>
    </tr>
        <tr>
      <td colspan="4"></td>
     </tr>
   <tr>
        <td colspan="4" height="15">
         
        </td>
      </tr>
          <tr>
            <td colspan="4">This is Service Entry page </td>
          </tr>
          <tr>
            <td colspan="4"> <%="Welcome normal user : "+userID+"!!!!!!!!!!!!!!"%></td>
          </tr>
          <td colspan="4">             
          </td>
  </table>
