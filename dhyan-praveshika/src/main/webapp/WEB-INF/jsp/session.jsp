 <%@page import="org.slf4j.Logger"%>
<%@page import="org.slf4j.LoggerFactory"%>
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