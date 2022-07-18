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
			// 로그인이 완료되면 메인 페이지로 리다이렉트
			response.sendRedirect(request.getContextPath() + "/");
			
		} else {
			// 로그인 실패에 대한 에러 메세지를 띄어주고 메인 화면으로 이동
			
			/* 
			 * 1) 공용으로 사용하는 에러 메세지 출력 페이지에 전달할 메세지와 메세지 출력 후 이동할 페이지를 request 객체에 저장한다.
			*/
			request.setAttribute("msg", "아이디 혹은 비밀번호가 일치하지 않습니다.");
			request.setAttribute("location", "/");
			
			/*
			 * 2) request 객체의 데이터를 유지해서 에러 메세지 출력 페이지에 전달하기 위해 forward() 실행
			 *  - msg.jsp로 포워딩 시키기
			 */
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			
		}
		
		
		
//		System.out.println(loginMember);
		
		
	} 

}
