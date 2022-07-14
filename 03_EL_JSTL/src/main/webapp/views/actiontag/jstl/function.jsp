<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Function Library</title>
</head>
<body>
	<h1>JSTL Function Library</h1>
	
	<c:set var="str" value="java oracle HTML CSS JavaScript jQuery Servlet JSP" />
	
	<p>원본 : ${ str } </p>
<%-- 	
	스크립트릿 사용시..!! 어휴 길다 길어!
	<%
		String str = (String) pageContext.getAttribute("str");
		
	%>
	
	<p>문자열 길이 :  <%= str.length() %></p>
	
	 --%>
	 
	 <p>문자열 길이 (JSTL Function Library) : ${ fn:length(str) }</p>
	 <p>대문자로 변경 : ${ fn:toUpperCase(str) }</p>
	 <p>소문자로 변경 : ${ fn:toLowerCase(str) }</p>
	 <p>CSS의 위치 : ${ fn:indexOf(str, "CSS") }</p>
	 <p>JSP를 JSTL로 변경 : ${ fn:replace(str, "JSP", "JSTL") }/p>
	 
	 <!-- 원본에는 영향 없음! -->
  	 <p>원본 : ${ str } </p>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>