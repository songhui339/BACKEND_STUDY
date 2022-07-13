<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String year = "2022";
	// String userName = request.getParameter("userName");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include 페이지</title>
</head>
<body>
	<h2>Include 페이지</h2>
	
	<p>includePage.jsp의 year 변수 값은 <%= year %> 입니다. </p>
	
	<%-- <p>userName : <%= userName %> </p> --%>
	<p>userName : ${ param.userName } </p>
	
	
	
	
	
	
	
	
</body>
</html>