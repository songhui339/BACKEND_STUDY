package com.kh.mvc.member.model.service;

import java.sql.Connection;

import com.kh.mvc.common.jdbc.JDBCTemplate;
import com.kh.mvc.member.model.dao.MemberDao;
import com.kh.mvc.member.model.vo.Member;

// 비지니스 로직을 처리하는 객체
// DB에 직접 접근하는 것이 아니라 DAO 객체를 통해서 접근
public class MemberService {

	public Member login(String id, String password) {
		// Connection은 service에서 처리하는 것이 좋음!
		// 오류 방지를 위하여!
		Connection connection = JDBCTemplate.getConnection();
		
		
		Member member = new MemberDao().findMemberById(connection, id);
		
		// 데이터베이스 정보를 다 읽어왔으니 close한다!
		JDBCTemplate.close(connection);
		
		if(member == null || !member.getPassword().equals(password)) {
			return null;
		} else {
			return member;
		}
	}

	
	public int save(Member member) {
		
		return 1;
	}

}
