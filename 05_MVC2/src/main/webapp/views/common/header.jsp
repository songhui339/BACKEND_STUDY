<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC2 패턴 실습</title>
<link rel="stylesheet" href="${ path }/resources/css/style.css">
<script src="${ path }/resources/js/jquery-3.6.0.js"></script>
</head>
<body>
	<header>
		<h1>Hello MVC</h1>
		<div class="login-container">
			<form id="loginFrm" action="${ path }/login" method="post">
				<table>
					<tr>
						<td>
							<input type="text" name="userId" id="userId" placeholder="아이디" required>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							<input type="password" name="userPwd" id="userPwd" placeholder="비밀번호" required>
						</td>
						<td>
							<input type="submit" value="로그인">						
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<label><input type="checkbox" name="saveId">아이디 저장</label>
							<input type="button" value="회원가입" onclick="location.href = '${ path }/member/enroll';"> 
						</td>
					</tr>
				</table>
			</form>
		</div>
		<nav>
			<ul class="main-nav">
				<li class="home"><a href="/">Home</a></li>
				<li id="board"><a href="/">게시판</a></li>
				<li id="admin-member"><a href="/">회원관리</a></li>
			</ul>
		</nav>
	</header> 