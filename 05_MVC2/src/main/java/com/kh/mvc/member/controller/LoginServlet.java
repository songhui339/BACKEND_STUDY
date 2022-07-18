package com.kh.mvc.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mvc.member.model.vo.Member;
import com.kh.mvc.member.model.service.MemberService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = null;
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		System.out.println(userId + ", " + userPwd);
		
		Member loginMember = new MemberService().login(userId, userPwd);
		
		// loginMember가 null이면 로그인 실패
		// loginMember가 null이 아니면 로그인 성공 
		if(loginMember != null) {
			//loginMember 객체를 세션에 저장
			session = request.getSession();
			
			session.setAttribute("loginMember", loginMember);
			
		}
		
		// 메인 페이지로 리다이렉트
		response.sendRedirect(request.getContextPath() + "/");
		
		
//		System.out.println(loginMember);
		
		
	} 

}
