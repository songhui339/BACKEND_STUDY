<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 내역</title>
</head>
<body>
	<h2>주문 내역</h2>
	
	<p>
		param : 해당 페이지 요청 시 전달된 파라미터 값을 받아올 때 사용하는 내장객체이다.<br>
		paramValues : 해당 페이지 요청 시 전달된 파라미터 값들을 배열로 받아올 때 사용하는 내장 객체이다.
	</p>
	
	<table border="1">
		<tr>
			<td>상품명</td>
			<td>${ param.pName }</td>
		</tr>
		<tr>
			<td>수량</td>
			<td>${ param.pCount }</td>
		</tr>
		
		<!-- 
			옵션 값은 2개지만 param 내장객체를 통해서도 접근이 가능하다.
			(단, 첫 번째 값만 가져올 수 있다.)
		 -->
		<tr>
			<td>옵션(param.option)</td>
			<td>${ param.option }</td>
		</tr>
		<tr>
			<td>옵션 1 </td>
			<td>${ paramValues.option[0] }</td>
		</tr>
		<tr>
			<td>옵션 2</td>
			<td>${ paramValues.option[1] }</td>
		</tr>
	</table>
	
	
	
	
	
	
	
	
</body>
</html>