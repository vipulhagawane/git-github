<% 
	System.out.println("session validation");
	HttpSession currentSession = request.getSession(false);
	if(currentSession == null){
		currentSession.invalidate();
		%>
		<jsp:forward page ="/error.jsp"/>
		<%
	}
	

%>