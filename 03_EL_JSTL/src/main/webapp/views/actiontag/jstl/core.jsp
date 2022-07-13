<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${ pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core Tags</title>
</head>
<body>
	<h1>JSTL Core Tags</h1>
	
	<h3>1. 변수</h3>
	<h4>1) 변수 선언 (c:set)</h4>
	<p>변수를 선언하고 초기 값을 대입하는 태그</p>
	
	<!-- 브라우저가 아닌 컨테이너에서 처리! -->
	<c:set var="number1" value="10" />
	<c:set var="number2" value="20" scope="request" />
	<c:set var="result" value="${ number1 + number2 }" scope="session" />
	<c:set var="array">
		red, blue, yellow, pink, green	
	</c:set>
	
	<p>number1 (EL) : ${ number1 } 또는 ${ pageScope.number1 }</p>
	<p>number1 (표현식 태그) / EL이 더 편함! : <%= pageContext.getAttribute("number1") %></p>
	<p>number2 : ${ number2 } 또는 ${ requestScope.number2 }</p>
	<p>result : ${ number1 } + ${ number2 } = ${ result } 또는 ${ sessionScope.result }</p>
	<p>array : ${ array } 또는 ${ pageScope.array }</p>
	
	<h4>2) 변수 삭제 (c:remove)</h4>
	<p>c:set 태그로 선언한 변수를 삭제할 때 사용하는 태그</p>
	
	<c:set var="result" value="99999" />
	<c:set var="result" value="10000" scope="request" />
	
	<p>삭제 전 : ${ result }</p>
	
	<h5>* 특정 scope에 변수 삭제</h5>
	<c:remove var="result" scope="page"/>
	
	<p>삭제 후 : ${ result }</p>
	
	<h5>* 모든 scope에 변수 삭제</h5>
	<!-- 모든 scope 변수 삭제를 원할 시 별도의 scope 지정 하지 않음! -->
	<c:remove var="result"/>	
	<p>삭제 후 : ${ result }</p>
	
	
	<h3>2. 출력 (c:out)</h3>
	<p>데이터 출력할 때 사용하는 태그</p>
	
	<p>태그를 문자열로 출력 : <c:out value="<b>태그로 출력하기</b>" escapeXml="true" /></p>
	<p>태그로 해석되어 출력 : <c:out value="<b>태그로 출력하기</b>" escapeXml="false" /></p>
	<p>태그로 해석되어 출력 : <c:out value="${ result }" default="<b>값이 없음</b>" escapeXml="false" /></p>
	
	
	<h3>3. 조건문</h3>
	<h4>1) c:if 태그</h4>
	<p>
		자바의 if 구문과 같은 역할을 하는 태그이다.<br>
		조건식은 test 속성에 EL 구문으로 기술해야 한다.
	</p>
	
	<c:if test="${ number1 > number2 } }">
		<b>number1이 number2보다 크다고한다~</b> <!-- false이므로 안 보인다! -->
	</c:if>
	
	<c:if test="${ number1 < number2 }">
		<b>number1이 number2보다 작다고 한다~</b> <!-- true이므로 보인다! -->
	</c:if>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>