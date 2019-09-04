<%@page import="org.slf4j.Logger"%>
<%@page import="org.slf4j.LoggerFactory"%>
<head>
<script>
if ( window.history.replaceState ) {
  window.history.replaceState( null, null, '/login' );
}
</script>
</head>
<% 
	Logger logger = LoggerFactory.getLogger(this.getClass());
	HttpSession currentSession = request.getSession(false);
	String loggedInUser = (String)currentSession.getAttribute("currentUser");
	logger.info("session validation : " + loggedInUser);
	if(loggedInUser == null)
	{
		logger.info("...invalid session...");
		%>
		<jsp:forward page ="login.jsp"/>
		<%
	}
	

%>