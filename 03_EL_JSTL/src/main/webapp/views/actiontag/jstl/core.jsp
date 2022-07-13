<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.el.model.vo.Student"%>
<%@page import="java.util.List"%>
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
	<c:set var="number1" value="99" />
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
	
	<!-- ------------------------------ -->
	
	<h4>2) c:choose 태그</h4>
	<p>
		- 자바의 switch 구문과 같은 역할을 하는 태그이다.<br>
		- 하위 태그인 c:when, c:otherwise 태그와 함께 사용되는데, 각각 switch 구문의 case, default 절과 비슷한 역할을 한다.
	</p>
	
	
	<c:choose>
		<c:when test="${ number1 > number2 }">
			<b>number1이 number2보다 크다고한다~</b>
		</c:when>
		<c:when test="${ number1 < number2 }">
			<b>number1이 number2보다 작다고 한다~</b>
		</c:when>
		
		<c:otherwise>
			<b>number1이 number2보다 크거나 작지 않다</b>
		</c:otherwise>
		
	</c:choose>
	
	<!-- ------------------------------ -->
	
	<h3>3. 반복문</h3>
	<h4>1) c:forEach 태그</h4>
	
	<p>자바의 for 구문에 해당하는 역할을 하는 태그</p>
	
	<!-- 자바의 for 구문처럼 사용하기 -->
	<c:forEach var="i" begin="1" end="6" step="2">
		<h${ i }>반복 확인 : ${ i }</h${ i }>
		
	</c:forEach>
	
	<!-- 자바의 향상된 for 구문처럼 사용하기 -->
	<c:forEach var="color" items="${ array }">
		<%-- ${ color  } <br> --%>
		<b style="color: ${ color };">${ color } </b>
	</c:forEach>
	
	<!-- Student 객체의 데이터를 표로 출력하기 -->
	<%
		List<Student> list = new ArrayList<> ();
		
		list.add(new Student("최송희", 29, 80, 80));
		list.add(new Student("이정후", 25, 70, 90));
		list.add(new Student("김태진", 28, 100, 100));
		list.add(new Student("이슬기", 31, 70, 70));
		
		pageContext.setAttribute("list", list);
	%>
	
	<h5>* 학생 목록 조회 (Student.java)</h5>
	<table border="1">
		<tr>
			<th>index</th>
			<th>순번</th>
			<th>First</th>
			<th>Last</th>
			<th>이름</th>
			<th>나이</th>
			<th>수학 점수</th>
			<th>영어 점수</th>
		</tr>
		<c:forEach var="student" items="${ list }" varStatus="status">
			<tr>
				<td>${ status.index}</td>
				<td>${ status.count}</td>
				<td>${ status.first}</td>
				<td>${ status.last}</td>
				<td>${ student.name }</td>
				<td>${ student.age }</td>
				<td>${ student.math }</td>
				<td>${ student.english }</td>
			</tr>
		</c:forEach>
	</table>
	
	
	<h4>2) c:forTokens 태그</h4>
	<p>문자열에 포함된 구분자를 통해 토큰을 분리해 반복을 수행하는 태그</p>
	
	<ul>
		<c:forTokens var="device" items="컴퓨터,노트북,핸드폰,에어컨/TV,냉장고.세탁기" delims=",/.">
			<li>${ device }</li>
		</c:forTokens>
	</ul>
	
	<ul style="width: 50%;">
		<c:forTokens var="color" items="pink aqua tomato yellow lime" delims=" ">
			<li style="background-color: ${ color };">${ color }</li>
		</c:forTokens>
	</ul>
	
	<h3>4. c:url 태그</h3>
	<p>URL을 생성하고 쿼리 스트링을 미리 설정하는 태그</p>
	
	<c:url var="url" value="/views/el/elParam.jsp" context="/01_Servlet">
		<c:param name="pName" value="갤럭시Z플립3" />
		<c:param name="pCount" value="2" />
		<c:param name="option" value="퍼플" />
		<c:param name="option" value="128GB" />
	</c:url>
	
	<a href="${ url }">이동 >></a>
	
	
	
	
	
	
	
	
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>