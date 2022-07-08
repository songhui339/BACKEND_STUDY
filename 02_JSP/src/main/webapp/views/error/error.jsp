<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
	<h1 style="text-align:center; color: red; font-weight: 800;">에러가 발생하였습니다.</h1>
	<h2 style="text-align:center;">관리자에게 문의해 주세요.</h2>
	<%= exception %><br>
	<%= exception.getMessage() %><br>
	<%= exception.getClass().getName() %><br>
	
</body>
</html>