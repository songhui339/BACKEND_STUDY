<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 내장 객체</title>
</head>
<body>
	<h1>JSP 내장 객체</h1>
	<%--
	<%
		String out = "";
	 %>
	 --%>
	
	<h2>1. request 객체</h2>
	<p>웹 브라우저의 요청 정보를 가지고 있는 객체</p>
	
	<h3>1) 헤더와 관련된 메소드</h3>
	<table border="1">
		<tr>
			<th>헤더</th>
			<th>값</th>
		</tr>
		
		<%
		Enumeration<String> names = request.getHeaderNames();
		
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			//System.out.println(name);
		%>
		<tr>
			<td><%= name %></td>
			<td><%= request.getHeader(name) %></td>
		</tr>
		
		<%
		}
		%>
	</table>
	
	
	<h3>2) URL/URLI, 요청 방식과 관련된 메소드</h3>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>값</th>
		</tr>
		
		<tr>
			<td>서버 도메인명</td>
			<td><%= request.getServerName() %></td>
		</tr>
		
		<tr>
			<td>서버 포트 번호</td>
			<td><%= request.getServerPort() %></td>
		</tr>
		
		<tr>
			<td>URL</td>
			<td><%= request.getRequestURL() %></td>
		</tr>
		
		<tr>
			<td>URI</td>
			<td><%= request.getRequestURI() %></td>
		</tr>
		
		<tr>
			<td>요청 쿼리</td>
			<td><%= request.getQueryString() %></td>
		</tr>
		
		<tr>
			<td>프로토콜</td>
			<td><%= request.getProtocol() %></td>
		</tr>
		
		<tr>
			<td>요청 방식</td>
			<td><%= request.getMethod() %></td>
		</tr>
		
		<tr>
			<td>웹 애플리케이션 경로</td>
			<td><%= request.getContextPath() %></td>
		</tr>
		
		<tr>
			<td>클라이언트의 IP 주소</td>
			<!-- 본인의 IP 주소..ㅎ  -->
			<td><%= request.getRemoteAddr() %></td>
		</tr>
		
		<tr>
			<td>클라이언트의 호스트 이름</td>
			<td><%= request.getRemoteHost() %></td>
		</tr>
		
	</table>
	<br><hr>
	<h2>2. response 객체</h2>
	<p>웹 브라우저의 요청에 대한 응답 객체</p>
	
	<h3>1) Redirect</h3>
	<p>
		sendRedirect(String url); <br>
		매개값으로 지정한 URL로 요청을 재전송한다. <br>
		리다이렉트 방식은 요청과 응답 객체를 새로 생성하므로 이전 요청과 응답 정보가 유지되지 않는다.
	</p>
	
	<a href="redirect.jsp">Redirect 테스트 >></a>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br>
</body>
</html>