<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	
	
	
	
</body>
</html>