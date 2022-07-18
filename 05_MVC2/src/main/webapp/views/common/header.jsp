<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html></html>
<head>
<meta charset="UTF-8">
<title>MVC2 패턴 실습</title>
<link rel="stylesheet" href="${ path }/resources/css/style.css">
<script src="${ path }/resources/js/jquery-3.6.0.js"></script>
</head>
<body></body>
	<header>
		<h1>Hello MVC</h1>
		<div class="login-container">
		<!-- 로그인 멤버가 없을 시 로그인 폼을 보여주도록 세팅 -->
			<c:if test="${ empty loginMember }">
				<form id="loginFrm" action="${ path }/login" method="post">
					<table>
						<tr>
							<td>
								<input type="text" name="userId" id="userId" placeholder="아이디" 
									value="${ empty cookie.saveId ? '' : cookie.saveId.value }" required>
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
								<label><input type="checkbox" name="saveId"
											${ empty cookie.saveId ? "" : "checked" }>아이디 저장</label>
								<input type="button" value="회원가입" onclick="location.href = '${ path }/member/enroll';"> 
							</td>
						</tr>
					</table>
				</form>
			</c:if>
			
			<c:if test="${ not empty loginMember }">
				<table>
					<tr>
						<td colspan="2">
							${ loginMember.name }님 안녕하세요.
						</td>
					</tr>
					<tr>
						<td>
							<button>내 정보</button>
						</td>
						<td>
							<button onclick="location.replace('${ path }/logout')">로그아웃</button>
						</td>
					</tr>
				</table>
			</c:if>
		</div>
		<nav>
			<ul class="main-nav">
				<li class="home"><a href="/">Home</a></li>
				<li id="board"><a href="/">게시판</a></li>
				<li id="admin-member"><a href="/">회원관리</a></li>
			</ul>
		</nav>
	</header> 