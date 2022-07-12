package com.kh.el.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.el.model.vo.Student;

@WebServlet("/el.do")
public class ELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ELServlet() {
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 세션 객체 가져오기
    	HttpSession session = request.getSession();
    	ServletContext application = request.getServletContext();
    	
    	// Request 영역에 데이터를 저장
    	request.setAttribute("classRoom", "C 강의장");
    	request.setAttribute("student", new Student("이정후", 20, 80, 80));
    	request.setAttribute("scope", "request");
    	
    	// Session 영역에 데이터를 저장 
    	session.setAttribute("classRoom", "D 강의장");
    	session.setAttribute("student", new Student("최송희", 18, 100, 100));
    	session.setAttribute("scope", "session");
    	
    	// Application 영역에 데이터를 저장
    	application.setAttribute("academy", "KH 정보교육원");
    	application.setAttribute("teacher", "문인수");
    	application.setAttribute("scope", "application");
    	
    	// 응답 화면은 JSP로 만들것임 
    	// servlet에서 데이터를 JSP로 전달!
    	// request에서도 forward 할수 있음 
    	request.getRequestDispatcher("views/el/el.jsp").forward(request, response);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
	}

}
