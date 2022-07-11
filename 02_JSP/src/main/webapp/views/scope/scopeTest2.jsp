<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<% 
	request.setAttribute("requestScope", "requestValue");
	pageContext.setAttribute("pageScope", "pageValue");
	
	// pageContext.forward("scopeTest3.jsp");
	response.sendRedirect("scopeTest3.jsp");
%>