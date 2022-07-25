<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>
<jsp:include page="/views/common/header.jsp" />

<style>
    section>div#board-write-container{width:600px; margin:0 auto; text-align:center;}
    section>div#board-write-container h2{margin:10px 0;}
    table#tbl-board{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-board th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-board td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    div#comment-container button#btn-insert{width:60px;height:50px; color:white; background-color:#3300FF;position:relative;top:-20px;}
    
    /*댓글테이블*/
    table#tbl-comment{width:580px; margin:0 auto; border-collapse:collapse; clear:both; } 
    table#tbl-comment tr td{border-bottom:1px solid; border-top:1px solid; padding:5px; text-align:left; line-height:120%;}
    table#tbl-comment tr td:first-of-type{padding: 5px 5px 5px 50px;}
    table#tbl-comment tr td:last-of-type {text-align:right; width: 100px;}
    table#tbl-comment button.btn-delete{display:none;}
    table#tbl-comment tr:hover {background:lightgray;}
    table#tbl-comment tr:hover button.btn-delete{display:inline;}
    table#tbl-comment sub.comment-writer {color:navy; font-size:14px}
    table#tbl-comment sub.comment-date {color:tomato; font-size:10px}
</style>
<section id="content">   
	<div id="board-write-container">
		<h2>게시판</h2>
		<table id="tbl-board">
			<tr>
				<th>글번호</th>
				<td>${ board.no }</td>
			</tr>
			<tr>
				<th>제 목</th>
				<td>${ board.title }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${ board.writerId }</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${ board.readCount }</td>
			</tr>
			<tr>
				<th>첨부파일</th>
			
				<td>
					<c:if test="${ empty board.originalFileName }">
						<span style="color: gray;"> - </span>
					</c:if>
					<c:if test="${ not empty board.originalFileName }">
						<img alt="file icon" src="${ path }/resources/images/file.png" width="20px" height="20px">
						<!-- 220725 파일 다운로드 로직 구현 -->
						<a href="javascript:" id="fileDown">
							<span>${ board.originalFileName }</span>
						</a>
						<%-- 
						<!-- 개인정보 관련 파일은 아래와 같이 다운로드 되도록 연결하면 안됨!!! 절대 안됨!!! -->
						<br><a href="${ path }/resources/upload/board${ board.renamedFileName }"
							download=${ board.originalFileName }>웹 루트에 파일 다운</a>
						 --%>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>내 용</th>
				<td>${ board.content }</td>
			</tr>
			<%--글작성자/관리자인경우 수정삭제 가능 --%>
			<tr>
				<th colspan="2">
					<c:if test="${ not empty loginMember && loginMember.id == board.writerId }">
						<button type="button" onclick="location.href='${ path }/board/update?no=${ board.no }'">수정</button>
						<button type="button" id="btnDelete">삭제</button>
					</c:if>
					<button type="button" onclick="location.href='${ path }/board/list'">목록으로</button>
				</th>
			</tr>
		</table>
		<div id="comment-container">
	    	<div class="comment-editor">
	    		<form action="${ pageContext.request.contextPath }/board/reply" method="POST">
	    			<input type="hidden" name="boardNo" value="${ board.no }">
					<textarea name="content" id="replyContent" cols="55" rows="3"></textarea>
					<button type="submit" id="btn-insert">등록</button>	    			
	    		</form>
	    	</div>
	    </div>
	    <table id="tbl-comment">
	    	<c:forEach var="reply" items="${ board.replies }">
		    	<tr class="level1">
		    		<td>
		    			<sub class="comment-writer"><c:out value="${ reply.writerId }"/></sub>
		    			<sub class="comment-date"><fmt:formatDate type="date" value="${ reply.createDate }"/></sub>
		    			<br>
		    			<c:out value="${ reply.content }"/>
		    		</td>
		    		<td>
		    			<c:if test="${ ! empty loginMember && loginMember.id == reply.writerId }">
	    					<button class="btn-delete">삭제</button>
    					</c:if>
		    		</td>
		    	</tr>
	    	</c:forEach>
	    </table>
</section>

<script>
	$(document).ready(() => {
		$('#btnDelete').on('click', () => {
			if(confirm('정말 게시글 삭제를 진행하겠습니까?')){
				// 삭제를 하려면 게시글의 no도 같이 넘겨줘야함
				location.replace('${ path }/board/delete?no=${ board.no }');
			}
		});
		
		// 파일 다운로드 앵커태그 기능 구현 
		$("#fileDown").on("click", () => {
			location.assign("${ path }/board/fileDown?oname=${ board.originalFileName }&rname=${ board.renamedFileName }")
		});
		
		$("#replyContent").on("focus", (e) => {
			if(${ empty loginMember }) {
				alert("로그인 후 이용해주세요!");
				
				$("#userId").focus();				
			}
		});
	});

</script>




<jsp:include page="/views/common/footer.jsp" /> 