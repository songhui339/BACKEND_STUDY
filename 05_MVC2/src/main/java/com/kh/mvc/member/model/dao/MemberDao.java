package com.kh.mvc.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// import com.kh.mvc.common.jdbc.JDBCTemplate;
import static com.kh.mvc.common.jdbc.JDBCTemplate.*;

import com.kh.mvc.member.model.vo.Member;

// 이 객체가 실제 DB와 연결되어 DB를 가져올 역할
public class MemberDao {

	public Member findMemberById(Connection connection, String id) {
		// return해야하는 참조객체를 꼭 처음에 만들어두어야한다!
		Member member = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// ?를 사용하지 않으면 아래처럼 작성해야함. 하지만 가독성이 떨어지고 효율이 떨어지기 때문에 ?를 사용
//		String query ="SELECT * FROM MEMBER WHERE ID=" + id + " AND STATUS='Y'";
		String query ="SELECT * FROM MEMBER WHERE ID=? AND STATUS='Y'";
		
		
		// 1. 오라클 JDBC 드라이버 등록 - 예외 처리(ClassNotFoundException / surround with try catch)
		try {
			pstm = connection.prepareStatement(query);
			
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			// 가져온 값을 출력
			if(rs.next()) {
				member = new Member();
				
				// member 객체에 로그인 정보 넣어주기 (한땀한땀)
				member.setNo(rs.getInt("NO"));
				member.setId(rs.getString("ID"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setRole(rs.getString("ROLE"));
				member.setName(rs.getString("NAME"));
				member.setPhone(rs.getString("PHONE"));
				member.setEmail(rs.getString("EMAIL"));
				member.setAddress(rs.getString("ADDRESS"));
				member.setHobby(rs.getString("HOBBY"));
				member.setStatus(rs.getString("STATUS"));
				member.setEnrollDate(rs.getDate("ENROLL_DATE"));
				member.setModifyDate(rs.getDate("MODIFY_DATE"));
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(pstm);
			close(rs);
			close(pstm);
		}
		
		return member;
	}

	// DB에 회원가입한 데이터 보내주는 용의 코드 
	public int insertMember(Connection connection, Member member) {
		int result = 0;
		// 멤버 추가 쿼리문 작성해둔 것임 
		String query = "INSERT INTO MEMBER VALUES(SEQ_UNO.NEXTVAL,?,?,DEFAULT,?,?,?,?,?,DEFAULT,DEFAULT,DEFAULT)";
		PreparedStatement pstm = null;
		
		try {
			pstm = connection.prepareStatement(query);
			
			// ? 부분의 정보를 넣어주기 (총 7개)
			pstm.setString(1, member.getId());
			pstm.setString(2, member.getPassword());
			pstm.setString(3, member.getName());
			pstm.setString(4, member.getPhone());
			pstm.setString(5, member.getEmail());
			pstm.setString(6, member.getAddress());
			pstm.setString(7, member.getHobby());
			
			// 쿼리문을 수행 한 후 영향받은 행의 개수를 result에 담아준다!
			result = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		
		
		return result;
	}

}
