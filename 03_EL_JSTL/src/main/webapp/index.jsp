<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL/JSTL</title>
</head>
<body>
	<h1>EL/JSTL</h1>
	
	<h2>1. EL(Expression Language)</h2>
	
	<p>
		- EL(Expression Language)은 JSP 2.0버전에서 추가된 표현 언어이다. <br>
		- 표현식(Expression) 태그를 대신하여 클라이언트에 출력하고자 하는 값들은 좀 더 간결하게 사용하는 방법이다.
	</p>
	
	<h3>1) EL</h3>
	
	<a href="el.do">View Details >></a>
	
	<h3>2) EL(Param) - 파라미터 처리</h3>
	<!-- action="/03_EL_JSTL/views/el/elParam.jsp -->
	<form action="${ pageContext.request.contextPath }/views/el/elParam.jsp" method="GET">
		<fieldset>
			<legend>제품 입력</legend>
			<input type="text" name="pName" placeholder="제품명을 입력하세요."><br><br>
			<input type="number" name="pCount" placeholder="수량을 입력하세요."><br><br>
			<input type="text" name="option" placeholder="옵션을 입력하세요."><br><br>
			<input type="text" name="option" placeholder="옵션을 입력하세요."><br><br>
			
			<input type="submit" value="전송">
			
		</fieldset>
	
	</form>
	
	<h3>3) EL 연산자</h3>
	
	<a href="${ pageContext.request.contextPath }/views/el/elOperators.jsp">View Details >></a>
	
	
	<h2>2. JSP 액션 태그</h2>
	<p>
		- JSP 페이지에서 자바 코드를 직접 입력하지 않고 특정 작업을 수행하는데 사용하는 태그이다.
		- 액션 태그의 경우 웹 브라우저에서 실행되는 것이 아니라 웹 컨테이너에서 실행된다.
	</p>
	
	<h3>1) 표준 액션 태그</h3>
	<p>
		JSP에서 기본으로 제공하는 태그 액션 태그로 별도의 라이브러리 설치 없이 바로 사용할 수 있다.
	</p>
	
	<p><a href="${ pageContext.request.contextPath }/views/actiontag/standard/include.jsp">jsp:include >></a></p>
	<p><a href="${ pageContext.request.contextPath }/views/actiontag/standard/forward.jsp">jsp:forward >></a></p>
	
	<h3>2) JSTL(JSP Standard Tag Library)</h3>
	<p>
		JSP 페이지에서 자주 사용하는 코드들을 사용하기 쉽게 태그로 만들어 표준으로 제공한다.
	</p>
	
	<h4>2-1) JSTL Core Tags</h4>
	<p>
		변수와 URL, 조건문, 반복문 등의 로직관 관련된 액션 태그를 제공한다.
	</p>
	
	<a href="${ pageContext.request.contextPath }/views/actiontag/jstl/core.jsp">View Details >></a>
	
	
	<!-- 20220714 진도 내용 -->
	<h4>2-2) JSTL Formatting Tags</h4>	
	<p>숫자의 포맷을 통화 기호, ',' 표시, % 표시 등 원하는 쓰임에 맞게 지정할 수 있는 태그이다.</p>
	<a href="${ pageContext.request.contextPath }/views/actiontag/jstl/formatting.jsp">View Details >></a>
	
	
	<h4>2-3) JSTL Function Library</h4>
	<p>
		EL 구문에서 문자열 처리에 관련된 메소드들을 사용할 수 있게 제공하는 라이브러리이다.
	</p>
	<a href="${ pageContext.request.contextPath }/views/actiontag/jstl/function.jsp">View Details >></a>
	
	
	
	
	
	
	
	
	
	
	
	
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>