package com.kh.servlet;
// JavaEE에 설치되어 있는 패키지 
// 우리가 설치한 건 JavaSE

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * HttpServlet : http 처리할 수 있는 서블렛!
 * 서버에서 서블릿을 실행시키는 방법 
 * 	1. 서블릿 클래스를 작성한다
 * 		- javax.servlet.http.HttpServlet 상속하는 클래스를 생성한다
 * 		- doGet(), doPost() 메소드를 재정의한다 
 * 		- 사용자의 요청에 따라서 응답하고 처리함
 * 	
 * 	2. 서블릿을 등록, URL을 매핑한다.
 * 		- web.xml에 서블릿 등록, URL 매핑 
 * 		- @WebServlet으로 서블릿 등록, URL 매핑
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FirstServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// GET 방식의 요청에 응답할 로직을 구현한다.
    	
    	// 문자 깨짐현상 방지하기 위해 Content-Type 응답 헤더를 설정한다.
    	response.setContentType("text/html;charset=utf-8");
    	
    	// 문자 기반의 output 스트림
    	// 응답 페이지를 작성해서 보내주면 브라우저가 띄워준다.
    	PrintWriter out = response.getWriter();
    	
    	out.write("<html>");
    	out.write("<body>");
    	out.write("<h1>우리가 만든 첫 번째 서블릿의 반환 내용</h1>");
    	out.write("</body>");
    	out.write("</html>");
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 방식의 요청에 응답할 로직을 구현한다 
		doGet(request, response);
	}

}
