<%--
--%>
<%@ page
    language="java" session="true" buffer="8kb"  isThreadSafe="true"  import="com.billydev.meb.security.servlets.*" 
%>
<%
AllRequest allRequest = new AllRequest(request);
AllResponse allResponse = new AllResponse(response);
SessionDataManager sdm = allRequest.getSessionDataManager();
com.billydev.meb.security.servlets.PageData pageData = sdm.getPageData();
String strPageName=pageData.getPageName(); 
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MEB</title>
<link href="css/jquery-ui.css" rel="stylesheet">
<link href="css/allstyles.css" rel="stylesheet">
</head>
<body>
<div id="wrapper">
<div id="header">
<!-- instead of an image tag we will use a background image and change it in the css -->
</div><!-- end header div -->
 <table border="0" cellpadding="0" cellspacing="0" width="765">
      <tr>
      <tr>
      <td>
         <%@ include file="/jsps/com/billydev/meb/security/pages/PageTitle.jsp" %>    
      </td>  
      </tr>
      <%
         if((sdm.getPageData().getValue("ErrMsg"))!=null) {
       %>
       <tr><td>
          <%@ include  file="/jsps/com/billydev/meb/security/pages/ErrorMessage.jsp" %>
          </td>
       </tr>
       <% } %>
       <tr>
       <td>
          <jsp:include page="<%= strPageName %>" />
          </td>
       </tr>
       <tr>
       <td>
       
          </td>
        </tr>
</table>
<%@ include file="/jsps/com/billydev/meb/security/pages/PageFooter.jsp" %></div>

</body>
</html>