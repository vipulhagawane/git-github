
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="u" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.dhyanpraveshika.dto.BlogDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	
	System.out.print("at new-->");
%>
<form:form modelAttribute="blog">
                <table width="500px">

                    <tr>
                        <td>Device Name : </td>
                        <td>${blog.id}</td>
                    </tr>

                    <tr>
                        <td>Model Name : </td>
                        <td>${blog.title}</td>
                    </tr>

                    <tr>
                        <td>Serial No : </td>
                        <td>${blog.description}</td>
                    </tr>

                    <tr>
                        <td>Device Id : </td>
                        <td>${blog.author}</td>
                    </tr>

                    <tr>
                        <td>Status : </td>
                        <td>${blog.category}</td>
                    </tr>
                    
                    <tr>
                        <td>Status : </td>
                        <td>${blog.encodedString}</td>
                    </tr>
                    
                </table>
            </form:form>

</body>
</html>