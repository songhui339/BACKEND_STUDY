package com.kh.mvc.member.model.service;

import java.sql.Connection;

import static com.kh.mvc.common.jdbc.JDBCTemplate.*;
import com.kh.mvc.member.model.dao.MemberDao;
import com.kh.mvc.member.model.vo.Member;

// 비지니스 로직을 처리하는 객체
// DB에 직접 접근하는 것이 아니라 DAO 객체를 통해서 접근
public class MemberService {

	public Member login(String id, String password) {
		// Connection은 service에서 처리하는 것이 좋음!
		// 오류 방지를 위하여!
		Connection connection = getConnection();
		
		
		Member member = new MemberDao().findMemberById(connection, id);
		
		// 데이터베이스 정보를 다 읽어왔으니 close한다!
		close(connection);
		
		if(member == null || !member.getPassword().equals(password)) {
			return null;
		} else {
			return member;
		}
	}

	
	public int save(Member member) {
		int result = 0;
		
		// DB에 접근은 MemberDao 객체를 통해서 접근한다.
		Connection connection = getConnection();
		
		result = new MemberDao().insertMember(connection, member);
		
		// 정상적으로 처리 되면 COMMIT 하고 아니면 ROLLBACK하자!
		// 코드가 간결화된건 JDBCTemplate에 구현되어 있기 때문이다!
		if(result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);
		
		return result;
	}

}
