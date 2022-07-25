package com.kh.mvc.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.mvc.board.model.vo.Board;
import com.kh.mvc.board.model.vo.Reply;
import com.kh.mvc.common.util.PageInfo;

import static  com.kh.mvc.common.jdbc.JDBCTemplate.*;

public class BoardDao {

	// DB에 저장된 게시글 수 가져오는 메소드 
	public int getBoardCount(Connection connection) {
		int count = 0;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM BOARD WHERE STATUS='Y'";
		
		try {
			pstm = connection.prepareStatement(query);
			rs = pstm.executeQuery();
			
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 역순으로 close() 하기 
			close(rs);
			close(pstm);
			
		}
		
		return count;
	}


	public List<Board> findAll(Connection connection, PageInfo pageInfo) {
		List<Board> list = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "SELECT RNUM, NO, TITLE, ID, CREATE_DATE, ORIGINAL_FILENAME, READCOUNT, STATUS "
				+ "FROM ("
				+    "SELECT ROWNUM AS RNUM, "
				+           "NO, "
				+ 			"TITLE, "
				+ 			"ID, "
				+ 			"CREATE_DATE, "
				+ 			"ORIGINAL_FILENAME, "
				+  			"READCOUNT, "
				+     		"STATUS "
				+ 	 "FROM ("
				+ 	    "SELECT B.NO, "
				+ 			   "B.TITLE, "
				+  			   "M.ID, "
				+ 			   "B.CREATE_DATE, "
				+ 			   "B.ORIGINAL_FILENAME, "
				+ 			   "B.READCOUNT, "
				+ 	   		   "B.STATUS "
				+ 		"FROM BOARD B "
				+ 		"JOIN MEMBER M ON(B.WRITER_NO = M.NO) "
				+ 		"WHERE B.STATUS = 'Y' ORDER BY B.NO DESC"
				+ 	 ")"
				+ ") WHERE RNUM BETWEEN ? and ?";
		
		try {
			pstm = connection.prepareStatement(query);
			
			// ? 채워 넣기
			pstm.setInt(1, pageInfo.getStartList());
			pstm.setInt(2, pageInfo.getEndList());
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setRowNum(rs.getInt("RNUM"));
				board.setNo(rs.getInt("NO"));
				board.setWriterId(rs.getString("ID"));
				board.setTitle(rs.getString("TITLE"));
				board.setCreateDate(rs.getDate("CREATE_DATE"));
				board.setOriginalFileName(rs.getString("ORIGINAL_FILENAME"));
				board.setReadCount(rs.getInt("READCOUNT"));
				board.setStatus(rs.getString("STATUS"));
				
				list.add(board);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
		}
		
		
		return list;
	}

	
	// 게시판 내용 No로 가져오기
	public Board findBoardByNo(Connection connection, int no) {
		Board board = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "SELECT  B.NO, "
							+ "B.TITLE, "
							+ "M.ID, "
							+ "B.READCOUNT, "
							+ "B.ORIGINAL_FILENAME, "
							+ "B.RENAMED_FILENAME, "
							+ "B.CONTENT, "
							+ "B.CREATE_DATE, "
							+ "B.MODIFY_DATE "
						+ "FROM BOARD B "
						+ "JOIN MEMBER M ON(B.WRITER_NO = M.NO) "
						+ "WHERE B.STATUS = 'Y' AND B.NO=?";
		
		try {
			pstm = connection.prepareStatement(query);
			
			pstm.setInt(1, no);
			
			
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				// 1건씩 조회되는 Data를 Board 객체로 바꿔주는 작업
				
				board = new Board();
				
				board.setNo(rs.getInt("NO"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriterId(rs.getString("ID"));
				board.setReadCount(rs.getInt("READCOUNT"));
				board.setOriginalFileName(rs.getString("ORIGINAL_FILENAME"));
				board.setRenamedFileName(rs.getString("RENAMED_FILENAME"));
				board.setContent(rs.getString("CONTENT"));
				board.setCreateDate(rs.getDate("CREATE_DATE"));
				board.setModifyDate(rs.getDate("MODIFY_DATE"));
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
		}
		
		return board;
	}


	// 삭제 로직
	public int updateStatus(Connection connection, int no, String status) {
		int result = 0;
		
		PreparedStatement pstm = null;
		String query = "UPDATE BOARD SET STATUS=? WHERE NO=?";
		
		try {
			pstm = connection.prepareStatement(query);
			
			// ? 부분 세팅하기
			pstm.setString(1, status);
			pstm.setInt(2, no);
			
			
			result = pstm.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		
		return result;
	}


	// 게시물 등록 로직
	public int insertBoard(Connection connection, Board board) {
		int result = 0;
		PreparedStatement pstm = null;
		String query = "INSERT INTO BOARD VALUES(SEQ_BOARD_NO.NEXTVAL,?,?,?,?,?,DEFAULT,DEFAULT,DEFAULT,DEFAULT)";
		
		try {
			pstm = connection.prepareStatement(query);
			
			// ? 부분 채워 넣기 
			pstm.setInt(1, board.getWriterNo());
			pstm.setString(2, board.getTitle());
			pstm.setString(3, board.getContent());
			pstm.setString(4, board.getOriginalFileName());
			pstm.setString(5, board.getRenamedFileName());
			
			result = pstm.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		
		
		return result;
	}


	// 게시물 수정 로직 
	public int updateBoard(Connection connection, Board board) {
		int result = 0;
		PreparedStatement pstm = null;
		String query = "UPDATE BOARD SET TITLE=?,CONTENT=?,ORIGINAL_FILENAME=?,RENAMED_FILENAME=?,MODIFY_DATE=SYSDATE WHERE NO=?";
		
		try {
			pstm = connection.prepareStatement(query);
			// ? 부분 채워 넣기
			pstm.setString(1, board.getTitle());
			pstm.setString(2, board.getContent());
			pstm.setString(3, board.getOriginalFileName());
			pstm.setString(4, board.getRenamedFileName());
			pstm.setInt(5, board.getNo());
			
			result = pstm.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		
		return result;
	}
	
	// 게시글 조회수 카운팅(증가) 로직 
	public int updateReadCount(Connection connection, Board board) {
		int result = 0;
		PreparedStatement pstm = null;
		String query = "UPDATE BOARD SET READCOUNT=? WHERE NO=?";
		
		try {
			pstm = connection.prepareStatement(query);
			
			// board객체를 변경하구 페이지에도 반영되어야하기 때문에 set과 get 작업 모두 다 해야한다!
			board.setReadCount(board.getReadCount() + 1);
			
			// ? 부분 채워넣기
			pstm.setInt(1, board.getReadCount());
			pstm.setInt(2, board.getNo());
			
			result = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		
		
		
		return result;
	}
	

	// 게시글 댓글 작성 및 조회 로직
	public int insertReply(Connection connection, Reply reply) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO REPLY VALUES(SEQ_REPLY_NO.NEXTVAL, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT)";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, reply.getBoardNo());
			pstmt.setInt(2, reply.getWriterNo());
			pstmt.setString(3, reply.getContent());
			
			result = pstmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	
	

}
