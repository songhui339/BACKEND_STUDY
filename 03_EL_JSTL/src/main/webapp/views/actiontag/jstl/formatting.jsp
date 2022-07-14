<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Formatting Tags</title>
</head>
<body>
	<h1>JSTL Formatting Tags</h1>
	
	<h2>1. formatNumber</h2>
	<p>
		숫자 데이터의 포맷을 지정할 때 사용하는 액션 태그이다.
	</p>
	
	<!-- groupingUsed 속성 : 숫자 단위의 구분자(,) 표시 여부 지정한다. -->
	숫자 출력 : <fmt:formatNumber type="number" value="123456789" groupingUsed="false" /><br>
	세 자리마다 구분하여 숫자 출력 : <fmt:formatNumber type="number" value="123456789" groupingUsed="true" /><br><br>
	
	<!-- #은 부족한 부분 채워주지 않지만 0은 '0'을 붙여준다 -->
	#을 이용해서 pattern 지정 : <fmt:formatNumber value="1.23" pattern="#.###"/><br>
	#을 이용해서 pattern 지정 : <fmt:formatNumber value="1.2346" pattern="#.###"/><br>
	0을 이용해서 pattern 지정 : <fmt:formatNumber value="1.23" pattern="0.000"/><br>
	0을 이용해서 pattern 지정 : <fmt:formatNumber value="1.2346" pattern="0.000"/><br>
	
	
	<table border="1">
		<tr>
			<td>숫자 출력</td>
			<td><fmt:formatNumber type="number" value="123456789" groupingUsed="false" /></td>
		</tr>
		<tr>
			<td>세 자리마다 구분하여 숫자 출력</td>
			<td><fmt:formatNumber type="number" value="123456789" groupingUsed="true" /></td>
		</tr>
		<tr>
			<td>#을 이용해서 pattern 지정</td>
			<td><fmt:formatNumber value="1.23" pattern="#.###"/></td>
		</tr>
		<tr>
			<td>#을 이용해서 pattern 지정</td>
			<td><fmt:formatNumber value="1.2346" pattern="#.###"/></td>
		</tr>
		<tr>
			<td>0을 이용해서 pattern 지정</td>
			<td><fmt:formatNumber value="1.23" pattern="0.000"/></td>
		</tr>
		<tr>
			<td>0을 이용해서 pattern 지정</td>
			<td><fmt:formatNumber value="1.2346" pattern="0.000"/></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
	</table>
	
	
	
	
	
	
	
	
	
</body>
</html>