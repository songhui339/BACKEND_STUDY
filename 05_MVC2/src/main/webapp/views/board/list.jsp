<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>
<jsp:include page="/views/common/header.jsp" />

<style>
	section#board-list-container{width:600px; margin:0 auto; text-align:center;}
	section#board-list-container h2{margin:10px 0;}
	table#tbl-board{width:100%; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
	table#tbl-board th, table#tbl-board td {border:1px solid; padding: 5px 0; text-align:center;} 
	/*글쓰기버튼*/
	input#btn-add{float:right; margin: 0 0 15px;}
	/*페이지바*/
	div#pageBar{margin-top:10px; text-align:center; background-color:rgba(0, 188, 212, 0.3);}
</style>
<section id="content">
	<h2 align="center">게시판 </h2>
	<div id="board-list-container">
		<!-- 로그인 했을 때만 글쓰기 버튼 보여지도록 세팅 -->
		<c:if test="${ not empty loginMember }">
			<button type="button" id="btn-add">글쓰기</button>
		</c:if>

		<table id="tbl-board">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>첨부파일</th>
				<th>조회수</th>
			</tr>
			<c:if test="${ empty list }">
				<tr>
					<td colspan="6">
						조회된 게시글이 없습니다.
					</td>
				</tr>	
			</c:if>	
			<c:if test="${ not empty list }">
				<c:forEach var="board" items="${ list }">
					<tr>
						<td>${ board.rowNum }</td>
						<td>
							<a href="${ path }/board/view?no=${ board.no }">
								${ board.title }
							</a>
						</td>
						<td>${ board.writerId }</td>
						<td>${ board.createDate }</td>
						<td>
							<c:if test="${ empty board.originalFileName }">
								<span> - </span>
							</c:if>
							<c:if test="${ not empty board.originalFileName }">
								<img alt="file icon" src="${ path }/resources/images/file.png" width="20px" height="20px">
							</c:if>
						</td>
						<td>${ board.readCount }</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<div id="pageBar">
			<!-- 맨 처음으로 -->
			<button onclick="location.href='${ path }/board/list?page=1'">&lt;&lt;</button>

			<!-- 이전 페이지로 -->
			<button onclick="location.href='${ path }/board/list?page=${ pageInfo.prevPage }'">&lt;</button>

			<!--  10개 페이지 목록 -->
			<!-- 반복문 작성 -->
			<c:forEach begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" varStatus="status">
				<!-- 선택한 페이지 버튼은 비활성화 -->
				<c:if test="${ status.current == pageInfo.currentPage }">
					<button disabled>${ status.current }</button>
				</c:if>
				<!-- 선택 되지 않은 페이지 버튼은 활성화 -->
				<c:if test="${ status.current != pageInfo.currentPage }">
					<button onclick="location.href='${ path }/board/list?page=${ status.current }'">${ status.current }</button>
				</c:if>
			</c:forEach>
			<!-- 
			<button disabled>1</button>
			<button>2</button>
			<button>3</button>
			<button>4</button>
			<button>5</button>
			<button>6</button>
			<button>7</button>
			<button>8</button>
			<button>9</button>
			<button>10</button> -->

			<!-- 다음 페이지로 -->
			<button onclick="location.href='${ path }/board/list?page=${ pageInfo.nextPage }'">&gt;</button>

			<!-- 맨 끝으로 -->
			<button onclick="location.href='${ path }/board/list?page=${ pageInfo.maxPage }'">&gt;&gt;</button>
		</div>
	</div>
</section>

<jsp:include page="/views/common/footer.jsp" />