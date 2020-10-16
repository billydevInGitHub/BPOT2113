<jsp:useBean id="SessionDataManager" scope="session" class="com.billydev.meb.security.servlets.SessionDataManager" />
<%
	com.billydev.meb.security.servlets.PageData pageData =SessionDataManager.getPageData();
	String userID=(String)pageData.getValue("userID");
	String infoMessage ="This is the Entry Of NORMAL USER :) :) :) "; 
 
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
            <td colspan="4"><%=infoMessage%></td>
          </tr>
          <tr>
            <td colspan="4"><%="Welcome to our site ..."+userID+"!"%></td>
          </tr>
          <td colspan="4"> 
            
          </td>
  </table>
