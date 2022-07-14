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
				// 1) readyState : 서버 응답 상태 확인 / AJAX 통신 진행 상황
				//				0 : 요청이 초기화되지 않은 상태 
				// 				1 : 서버와 연결이 성사 됨 
				//				2 : 서버가 요청을 받은 상태 
				//				3 : 서버가 요청을 처리하는 상태 
				//				4 : 서버가 요청에 대한 처리가 끝나고 응답을 준비하는 상태 
				console.log("서버 응답 상태 확인 : " + xhr.readyState);

				if(xhr.readyState === 4) {
					/*
						2) status : HTTP 응답 상태 코드
							200 : OK
							403 : Forbidden
							404 : Not Found
							500 : Internal Server Error
							...
					*/
					console.log("응답 상태 : " + xhr.status);
					
					if(xhr.status === 200) {
						// 서버에서 응답한 데이터를 담고 있는 속성 
						console.log(xhr.responseText);
						
						document.getElementById("area1").innerHTML = xhr.responseText;
					} else {
						console.log("통신 실패 : " + xhr.status);
					}

				}
			}

			// 3. open() 호출
			//  - 서버와 통신에 필요한 정보를 입력한다. (요청 방식, 대상(서버), 동기/비동기 여부(default: true))
			xhr.open("GET", "${ path }/jsAjax.do?name=최송희&age=29", true);


			// 4. send() 호출
			//	- 서버에 요청을 한다.
			xhr.send();
		}	
	
	</script>

	<h3>2) POST 방식으로 서버에 데이터 전송 및 응답</h3>
	
	<button onclick="jsAjaxTest2();">POST 방식 전송</button>

	<p id="area2"></p>
	
	<script>
		function jsAjaxTest2() {
			// 1. XMLHttpRequest 객체 생성
			let xhr = new XMLHttpRequest();

			// 2. onreadystatechange 콜백함수 지정
			xhr.onreadystatechange = () => {
				// 1) 통신 진행 상황 확인 
				if(xhr.readyState === xhr.DONE && xhr.status === 200) {
					document.getElementById("area2").innerHTML = xhr.responseText;
				} 
				// else {
				// 	console.log("통신 실패 : " + xhr.status);
				// }
			};

			// 3) open() 메소드 호출
			xhr.open("POST", "${ path }/jsAjax.do", true);

			// POST방식의 경우 header 설정 필요
			// * POST 요청의 경우 send() 메소드 호출 전에 아래와 같이 요청 헤더를 추가해야 한다.
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

			// 4) send() 메소드 호출
			xhr.send("name=이정후&age=25");

		}
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>