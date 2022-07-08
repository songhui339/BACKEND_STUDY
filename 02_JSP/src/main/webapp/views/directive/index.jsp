<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directive Tag</title>
</head>
<body>
	<h1>지시자 태그</h1>
	
	<section>
		<h2>개인 정보 입력</h2>
	
		<form action="userFormResult.jsp" method="POST">
			<label>이름 : <input type="text" name="userName" size="10"></label> <br>
			<label>나이 : <input type="text" name="userAge" size="10"></label> <br>
			<label>성별</label>
			<label><input type="radio" name="gender" value="남자">남자</label>
			<label><input type="radio" name="gender" value="여자">여자</label> <br>
			<label>키 : <input type="number" name="height" min="140" max="200"></label> <br>
		
			<label>좋아하는 음식 : </label>
			<label><input type ="checkbox" name="food" value="한식">한식</label> 
			<label><input type ="checkbox" name="food" value="분식">분식</label> 
			<label><input type ="checkbox" name="food" value="중식">중식</label> 
			<label><input type ="checkbox" name="food" value="일식">일식</label> 
			<label><input type ="checkbox" name="food" value="분식">분식</label> 
		
			<br><br>
			
			<input type="submit" value="전송">
			<input type="reset" value="취소">
		
		</form>
	</section>

</body>
</html>