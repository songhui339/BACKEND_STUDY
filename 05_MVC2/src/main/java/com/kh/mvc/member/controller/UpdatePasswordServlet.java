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


@WebServlet(name="updatePwd", urlPatterns = "/member/updatePwd")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdatePasswordServlet() {
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비밀번호변경하는 화면 보여주기
		request.getRequestDispatcher("/views/member/updatePwd.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비밀번호 변경시 동작 내용
		// 로그인이 되어 있는지 확인하기 (MyPageServlet.java 에서 가져옴)
		int result = 0;
    	HttpSession session = request.getSession(false);
    	Member loginMember = (session == null) ? null : (Member) session.getAttribute("loginMember");
    	String userPwd = request.getParameter("userPwd");
    	
    	// 
    	if (loginMember != null ) {
    		result = new MemberService().updatePassword(loginMember.getNo(), userPwd);
    		
    		// 비밀번호 변경 로직  (DeleteServlet.java 참고)
    		if(result > 0) {
    			// 비밀번호 변경 성공
    			request.setAttribute("msg", "비밀번호 변경이 완료 되었습니다.");
    			// 비밀번호 변경 성공 후 창을 닫아주는 코드를 전달 
    			request.setAttribute("script", "self.close()");
    			
    		} else {
    			// 비밀번호 변경 실패
    			request.setAttribute("msg", "비밀번호 변경에 실패 했습니다.");
    			request.setAttribute("location", "/member/updatePwd");
    		}
    		
    		
    		
    	} else {
    		request.setAttribute("msg", "로그인 후  수정해주세요.");
    		// 창 닫아주는 코드
    		request.setAttribute("script", "self.close()");
			
    	}
    	
    	request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}	
		
}


