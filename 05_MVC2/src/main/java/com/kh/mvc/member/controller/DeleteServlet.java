package com.kh.mvc.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mvc.member.model.service.MemberService;
import com.kh.mvc.member.model.vo.Member;

@WebServlet("/member/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteServlet() {
    }

    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인이 되어 있는지 확인하기 (MyPageServlet.java 에서 가져옴)
    	HttpSession session = request.getSession(false);
    	Member loginMember = (session == null) ? null : (Member) session.getAttribute("loginMember");
    	int result = 0;
    	
    	// 로그인이 되어 있으면 탈퇴 진행 그렇지 않으면 alert창 띄운 후 메인 페이지로 이동
    	if (loginMember != null ) {
    		result = new MemberService().delete(loginMember.getNo());
    		
    		// 회원 탈퇴 로직 만들기 (UpdateServlet.java 참고)
    		if(result > 0) {
    			// 탈퇴 성공
    			request.setAttribute("msg", "정상적으로 탈퇴 처리 되었습니다.");
    			request.setAttribute("location", "/logout");
    		} else {
    			// 탈퇴 실패
    			request.setAttribute("msg", "탈퇴 처리에 실패했습니다.");
    			request.setAttribute("location", "/member/myPage");
    		}
    		
    		
    		
    	} else {
    		request.setAttribute("msg", "로그인 후  탈퇴해주세요.");
			request.setAttribute("location", "/");
			
    	}
    	
    	request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

}
