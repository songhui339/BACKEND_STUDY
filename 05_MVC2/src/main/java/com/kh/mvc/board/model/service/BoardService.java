package com.kh.mvc.board.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.mvc.board.model.dao.BoardDao;
import com.kh.mvc.board.model.vo.Board;
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

}
