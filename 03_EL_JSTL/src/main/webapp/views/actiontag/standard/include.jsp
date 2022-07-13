<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp:include 액션 태그</title>
</head>
<body>
	<h1>jsp:include 액션 태그</h1>
	<p>
		현재 JSP 페이지에 다른 페이지를 포함하고자 할 때 사용하는 액션 태그이다.
	</p>
	
	<h2>1. include 지사자 (정적 include 방식)</h2>
	<p>
		다른 페이지를 포함하는 JSP 파일이 컴파일 되기 전에 페이지에 삽입된다.
	</p>
	<%-- 
	<%@ include file="includePage.jsp" %>
	
	<p>Include 한 페이지의 year 변수 값은 <%= year %> 입니다. (접근 가능)</p>
	
	<%
		// 현재 페이지와 include된 페이지의 변수명이 중복되어 Duplicate local variable이 발생한다.
		// String year = "2023";
	%>
	 --%>
	 
	<h2>2. include 액션 태그 (동적 include 방식)</h2>
	<p>
		다른 페이지를 포함하는 JSP 파일이 화면에 출력되는 시점(Runtime, 실행되는 시점)에 삽입된다.
	</p>
	
	<%-- <jsp:include page=""></jsp:include> --%>
	<jsp:include page="includePage.jsp" />
	
	
	<%
		String year = "2023";
	%>
	
	<p>include.jsp의 year 변수 값은 <%= year %> 입니다.</p>
	
	
	<!-- jsp:param 액션태그를 이용해 include된 페이지로 값을 전달할 수 있다. -->
	<jsp:include page="includePage.jsp">
		<jsp:param name="userName" value="최송희"/>
	</jsp:include>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>