package com.kh.mvc.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.mvc.member.model.vo.Member;

// 이 객체가 실제 DB와 연결되어 DB를 가져올 역할
public class MemberDao {

	public Member findMemberById(String id) {
		// return해야하는 참조객체를 꼭 처음에 만들어두어야한다!
		Member member = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// ?를 사용하지 않으면 아래처럼 작성해야함. 하지만 가독성이 떨어지고 효율이 떨어지기 때문에 ?를 사용
//		String query ="SELECT * FROM MEMBER WHERE ID=" + id + " AND STATUS='Y'";
		String query ="SELECT * FROM MEMBER WHERE ID=? AND STATUS='Y'";
		
		
		// 1. 오라클 JDBC 드라이버 등록 - 예외 처리(ClassNotFoundException / surround with try catch)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. 오라클 DB에 연결 (Add Catch exception)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@10.211.55.3:1521:xe", "WEB", "WEB");
			
			// 3. statement 등록
			pstm = conn.prepareStatement(query);
			
			// ?(위치 홀더) 만들어서 퀴리문 수행 전에 Id로 세팅해둠 (의미 : 첫번째 물음표는 ID임)
			pstm.setString(1, id);
			
			// 쿼리문 실행 후 그 결과값을 ResultSet으로 리턴해주는 역할
			rs = pstm.executeQuery();
			
			// 가져온 값을 출력
			if(rs.next()) {
				// 컬럼명을 넣어줌
				System.out.println(rs.getInt("NO"));
				System.out.println(rs.getString("ID"));
				System.out.println(rs.getString("NAME"));
				System.out.println(rs.getString("ROLE"));
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// conn.close(); -> surround with try catch 예외 처리 
			try {
				// close(); 할떄는 생성된 순선의 역순으로 작성
				rs.close();
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return member;
	}

}
