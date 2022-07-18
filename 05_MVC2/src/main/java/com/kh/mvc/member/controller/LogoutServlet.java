package com.kh.mvc.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LogoutServlet() {
    	
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그아웃 순서
    	
    	// 1. 세션을 얻어오기
    	// 현재 세션 객체가 있으면 가져오고 없으면 null 리턴한다.
    	HttpSession session = request.getSession(false);
    	
    	// 2. 얻어온 세션을 삭제하기
    	if(session != null) {
    		// delete() 라는 메소드는 없음!
    		session.invalidate();
    	}
    	
    	// 3. 삭제 후 메인 화면으로 리다이렉트
    	response.sendRedirect(request.getContextPath() + "/");
	}

}
