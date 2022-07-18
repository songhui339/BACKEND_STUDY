package com.kh.mvc.member.model.service;

import com.kh.mvc.member.model.dao.MemberDao;
import com.kh.mvc.member.model.vo.Member;

// 비지니스 로직을 처리하는 객체
// DB에 직접 접근하는 것이 아니라 DAO 객체를 통해서 접근
public class MemberService {

	public Member login(String id, String password) {
		Member member = null;
		
		member = new MemberDao().findMemberById(id);
		
		
		return member;
	}

}
