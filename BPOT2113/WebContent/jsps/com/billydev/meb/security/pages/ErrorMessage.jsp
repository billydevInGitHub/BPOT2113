<%@ page
    language="java" session="true" buffer="8kb"  isThreadSafe="true"  import="com.billydev.meb.security.servlets.*" 
%>
<jsp:useBean id="SessionDataManager" scope="session" class="com.billydev.meb.security.servlets.SessionDataManager" />

<b>
<%=(String)SessionDataManager.getPageData().getValue("ErrMsg")%>
</b>
