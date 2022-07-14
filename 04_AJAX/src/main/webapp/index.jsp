<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${ pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
</head>
<body>
	<h1>AJAX(Asynchronous JavaScript and XML)</h1>
	
	<h2>1. JavaScript를 이용한 AJAX 테스트</h2>
	<h3>1) GET 방식으로 서버에 데이터 전송 및 응답</h3>
	
	<button onclick="jsAjaxTest1();">GET 방식 전송</button>

	<p id="area1"></p>
	
	<script>
		function jsAjaxTest1() {
			// 1. XMLHttpRequest 객체 생성 
			let xhr = new XMLHttpRequest();
			/*
			// 구버전을 위한 호환성 코드입니다. 더 이상 이렇게 작성하지 않아도 됩니다.
			if (window.XMLHttpRequest) { // 모질라, 사파리, IE7+ ...
			httpRequest = new XMLHttpRequest();
			 } else if (window.ActiveXObject) { // IE 6 이하
				httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
			}
			*/

			// 2. onreadystatechange 속성에 콜백함수 지정 -> 서버 응답 처리 함수 생성 (콜백함수) 
			// - 비동기 통신에 대한 응답 상태에 변경이 있을 경우 실행된다.
			// 익명함수나 화살표함수 모두 사용 가능
			xhr.onreadystatechange = function() {
				console.log(xhr.readyStatus);
				console.log(xhr.responseText);
			}

			// 3. open() 호출
			//  - 서버와 통신에 필요한 정보를 입력한다. (요청 방식, 대상(서버), 동기/비동기 여부(default: true))
			xhr.open("GET", "${ path }/jsAjax.do?name=최송희&age=29", true);


			// 4. send() 호출
			//	- 서버에 요청을 한다.
			xhr.send();








		}	
	
	
	
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>