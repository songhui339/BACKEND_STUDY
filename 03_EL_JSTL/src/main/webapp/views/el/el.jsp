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
		2. EL은 객체의 필드에 직접 접근하는 것 처럼 보이지만 내부적으로는 해당 객체의 Getter 메소드로 접근해서 값을 읽어오는 것이다.
	 -->
	<p>강의장 : ${classRoom}</p>
	<p>수강생 : ${ student.name }, ${ student.age }</p>
	<p>강의장 : ${sessionScope.classRoom}</p>
	<p>수강생 : ${ sessionScope.student.name }, ${ sessionScope.student.age }</p>
	
	<h2>3. EL 사용 시 내장 객체에 저장된 속성명이 같은 경우</h2>
	<%
		pageContext.setAttribute("scope", "page");
	%>
	<!-- 
		여러 영역에 동일한 속성명을 가지는 데이터를 저장했다면, 명시적으로 영역(Scope)를 지정해서 원하는 영역의 속성값을 읽어올 수 있다.
	 -->
	scope : ${ scope }<br>
	requestScope : ${ requestScope.scope }<br>
	sessionScope : ${ sessionScope.scope } <br>
	applicationScope : ${ applicationScope.scope }
	
	<h2>4. ContextPath 가져오기</h2>
	<p>Context는 톰캣 위에서 구동되는 각각의 애플리케이션이다. <br> Contextpath는 애플리케이션을 찾아가기 위한 경로</p>
	<h3>1) 표현식 태그를 사용하는 방법</h3>
	<table border="1">
		<tr>
			<td>ContextPath</td>
			<td><%= request.getContextPath() %></td>
		</tr>
	</table>
	
	<h3>2) EL을 사용하는 방법 </h3>
	<table border="1">
		<tr>
			<td>ContextPath</td>
			<td>${ pageContext.request.contextPath }</td>
		</tr>
	</table>
	
	<h2>5. 헤더에 접근하기</h2>
	<h3>1) 표현식 태그를 사용하는 방법</h3>
	<table border="1">
		<tr>
			<td>Host</td>
			<td><%= request.getHeader("host") %></td>
		</tr>
		<tr>
			<td>User-Agent</td>
			<td><%= request.getHeader("User-Agent") %></td>
		</tr>
	</table>
	
	<h3>2) EL을 사용하는 방법 </h3>
	<table border="1">
		<tr>
			<td>Host</td>
			<td>${ header.host }</td>
		</tr>
		<tr>
			<td>User-Agent</td>
			<td>${ header['User-Agent'] }</td>
		</tr>
	</table>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	
</body>
</html>