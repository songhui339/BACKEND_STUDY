package com.kh.mvc.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mvc.member.model.vo.Member;

@WebServlet("/member/myPage")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyPageServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 로그인이 되어 있는지 확인하기
    	HttpSession session = request.getSession(false);
    	Member loginMember = (session == null) ? null : (Member) session.getAttribute("loginMember");
    	
    	// 로그인이 되어 있으면 myPage로 forward 하구 그렇지 않으면 alert창 띄운 후 메인 페이지로 이동
    	if (loginMember != null ) {
    		// myPage.jsp로 forward하기
    		request.getRequestDispatcher("/views/member/myPage.jsp").forward(request, response);
    	} else {
    		request.setAttribute("msg", "로그인 후  수정해주세요.");
			request.setAttribute("location", "/");
			
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
    	}
    	
    	
    	
	}

}
