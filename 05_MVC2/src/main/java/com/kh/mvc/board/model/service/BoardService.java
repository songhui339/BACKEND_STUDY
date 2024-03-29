package com.kh.mvc.board.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.mvc.board.model.dao.BoardDao;
import com.kh.mvc.board.model.vo.Board;
import com.kh.mvc.board.model.vo.Reply;
import com.kh.mvc.common.util.PageInfo;

import static com.kh.mvc.common.jdbc.JDBCTemplate.*;

public class BoardService {
	
	// DB에 저장된 게시글 수 가져오는 메소드 
	public int getBoardCount() {
		int count = 0;
		Connection connection = getConnection();
		
		
		// 데이터는 Dao 통해서 가져온다!
		count = new BoardDao().getBoardCount(connection);
		
		
		close(connection);
		
		return count;
	}
	
	// DB에 조회되는 행 하나하나를 Board 객체로 만들어 List 객체에 담아주는 것!
	public List<Board> getBoardList(PageInfo pageInfo) {
		List<Board> list = null;
		Connection connection = getConnection();
		
		
		list = new BoardDao().findAll(connection, pageInfo);
		
		
		close(connection);
		
		return list;
	}

	public Board getBoardByNo(int no, boolean hasRead) {
		Board board = null;
		Connection connection = getConnection();
		
		board = new BoardDao().findBoardByNo(connection, no);
		
		// 220725 게시글 조회수 카운팅(증가) 로직 추가
		if(board != null && !hasRead) {
			int result = new BoardDao().updateReadCount(connection, board);
			
			if(result > 0) {
				// 테이블에 반영 
				commit(connection);
			} else {
				rollback(connection);
			}
		}
		
		close(connection);
		
		return board;
	}

	// 게시글 삭제 메소드
	public int delete(int no) {
		int result = 0;
		Connection connection = getConnection();
		
		result = new BoardDao().updateStatus(connection, no, "N");
		
		if(result > 0) {
			// 삭제 성공 시
			commit(connection);
		} else {
			rollback(connection);
		} 
		
		close(connection);
		
		return result;
	}

	// 게시물 등록 및 수정 서비스 로직
	public int save(Board board) {
		int result = 0;
		Connection connection = getConnection();
		
//		result = new BoardDao().insertBoard(connection, board);
		
		if(board.getNo() != 0) {
			// update 작업 진행 
			result = new BoardDao().updateBoard(connection, board);
		} else {
			// insert 작업 진행
			result = new BoardDao().insertBoard(connection, board);
		}
		
		
		if(result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		} 
		
		close(connection);

		
		return result;
	}

	// 게시글 댓글 작성 및 조회 로직
	public int saveReply(Reply reply) {
		int result = 0;
		Connection connection = getConnection();
		
		result = new BoardDao().insertReply(connection, reply);
		
		if(result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);
		
		return result;
	}

}
