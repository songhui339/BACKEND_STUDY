<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core Tags</title>
</head>
<body>
	<h1>JSTL Core Tags</h1>
	
	<h2>1. 변수</h2>
	<h3>1) 변수 선언 (c:set)</h3>
	<p>변수를 선언하고 초기 값을 대입하는 태그</p>
	
	<c:set var="number1" value="10" />
	
	<p>number1 (EL) : ${ number1 } 또는 ${ pageScope.number1 }</p>
	<p>number1 (표현식 태그) / EL이 더 편함! : <%= pageContext.getAttribute("number1") %></p>
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>