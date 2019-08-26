<% 
	System.out.println("session validation");
	HttpSession currentSession = request.getSession(false);
	String loggedInUser = (String)currentSession.getAttribute("currentUser");
	System.out.println("session validation : " + loggedInUser);
	if(loggedInUser == null)
	{
		System.out.println("...invalid session...");
		%>
		<jsp:forward page ="login.jsp"/>
		<%
	}
	

%>