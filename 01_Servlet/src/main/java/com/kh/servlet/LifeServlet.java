package com.kh.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/life.do")
public class LifeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LifeServlet() {
    	System.out.println("서블릿 생성");
    }
    
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 메소드 실행");
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 메소드 실행");
		super.service(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 메소드 실행");
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public void destroy() {
		System.out.println("destroy() 메소드 실행");
	}

}
