<%@page import="com.kh.el.model.vo.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* 1. 기존 방식으로 request, session 객체에 담겨있는 데이터를 출
	// Request 영역에 저장된 속성(Attribute, 즉 데이터)을 가져온다
	String classRoom = (String) request.getAttribute("classRoom");
	// 가져오려면 object에서 String 타입으로 형변환 해야한다!
	Student student = (Student) request.getAttribute("student");
	
	
	// Session 영역에 저장된 Attribute(속성)을 가져온다
	String classRoom2 = (String) session.getAttribute("classRoom");
	Student student2 = (Student) session.getAttribute("student");
	*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL(Expression Language)</title>
</head>
<body>
	<h1>EL(Expression Language)</h1>
	
	<h2>1. 기존 방식으로 request, session 객체에 담겨있는 데이터를 출력</h2>
	<%-- <h4>[request 영역에 저장된 Attribute]</h4>
	<p>강의장 : <%= classRoom %></p>
	<p>수강생 : <%= student.getName() %>, <%= student.getAge() %></p>
	
	<h4>[session 영역에 저장된 Attribute]</h4>
	<p>강의장 : <%= classRoom2 %></p>
	<p>수강생 : <%= student2.getName() %>, <%= student2.getAge() %></p> --%>
	
	<h2>2. EL 방식으로 request, session 객체에 담겨있는 데이터를 출력</h2>
	<!-- 
		1. EL은 영역 객체에 저장된 속성(Atrtribute) 속성명을 검색해서 존재하는 경우 값을 가져온다.
			Page 영역 → Request 영역 → Session 영역 → Application 영역 순으로 해당 속성을 찾아서 값을 가져온다 
	 -->
	<p>강의장 : ${classRoom}</p>
	<p>수강생 : ${ student.name }, ${ student.age }</p>
	
	
	
</body>
</html>