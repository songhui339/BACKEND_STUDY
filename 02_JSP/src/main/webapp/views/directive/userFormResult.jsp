<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	request.setCharacterEncoding("UTF-8");

	// 폼 파라미터 읽어오기
	String userName = request.getParameter("userName");
	String userAge = request.getParameter("userAge");
	String gender = request.getParameter("gender");
	String height = request.getParameter("height");
	String[] food = request.getParameterValues("food");
	
	
	System.out.println(userName); 
	System.out.println(userAge); 
	System.out.println(gender); 
	System.out.println(height);
	Arrays.stream(food).forEach(System.out::print);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userFormResult</title>
</head>
<body>
	<h2>개인 정보 입력 결과</h2>
	
	<%= userName %>님 안녕하세요. <br>
	<%= userName %>님은 <%= userAge %>세 이고 키는 <%= height %>cm인 <%= gender %>입니다. <br>
	좋아하는 음식은 
	<%
		for(String f : food) {	
	%>
	
	<span style="color: tomato;"><%= f + " "%></span>
	
	
	<% 
		} 
	%>	
	입니다. 
	
	
	
	
	
	
	
</body>
</html>