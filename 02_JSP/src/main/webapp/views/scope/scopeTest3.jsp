<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scopeTest3</title>
</head>
<body>
	<h2>request 영역과 page 영역 비교</h2>
	
	<p>requestValue : <%= request.getAttribute("requestScope") %></p>
	<!-- 페이지가 달라졌기 때문에 값을 읽어올 수 없음 -->
	<p>pageValue : <%= pageContext.getAttribute("pageScope") %></p>
</body>
</html>