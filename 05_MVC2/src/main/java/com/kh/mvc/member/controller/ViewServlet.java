package com.kh.mvc.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mvc.board.model.service.BoardService;
import com.kh.mvc.board.model.vo.Board;

@WebServlet("/board/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Board board = null;
		int no = Integer.parseInt(request.getParameter("no"));
//		System.out.println("게시글 번호 : " + no);
		
		
		/*
		 * 새로 고침 시 조회 수가 증가하는 것을 방지하는 로직 작성
		 * 쿠키에 조회한 게시글의 번호를 기록하여 한 번 조회하면 그 뒤에는 조회 수가 올라가지 않도록 설정
		 * 무분별한 새로고침으로 조회수가 증가되지 않도록 로직 구현
		 */
		// 1. 쿠키에 조회한 이력이 있는지 확인 
		// 쿠키가 있으면 배열로 리턴 - 없으면 null로 리턴
		Cookie[] cookies = request.getCookies();
		String boardHistory = ""; // 실제로 조회한 게시글 번호를 저장하는 변수
		boolean hasRead = false; // 조회한 글이면 true, 조회된 것이 아니라면 false를 담아줄 변수
		
		if(cookies != null) {
			String name = null;
			String value = null;
			
			for (Cookie cookie : cookies) {
				name = cookie.getName();
				value = cookie.getValue();
				
				// boardHistory인 쿠키 값을 찾기
				if(name.equals("boardHistory")) {
					boardHistory = value;
					
					// 해당하는 문자열이 존재하면 (contains)
					if (value.contains("|" + no + "|")) {
						// 조회한 글이니까 true를 담아주기!
						hasRead = true;
						
						// 반복될 필요 없으니 반복문 나가기
						break;
					}
				}
				
			}
		}
		
		// 2. 읽지 않은 게시글이면 cookie에 기록
		if(!hasRead) {
			Cookie cookie = new Cookie("boardHistory", boardHistory + "|" + no + "|");
			
			cookie.setMaxAge(-1); // 브라우저 종료 시 삭제
			response.addCookie(cookie);
			
		}
		
		
		
		
//		조회한 객체를 board에 전달
		board = new BoardService().getBoardByNo(no, hasRead);
		
		
//		request.setAttribute("board", board);
//		request.getRequestDispatcher("/views/board/view.jsp").forward(request, response);
		
		
		if(board != null) {
			// 게시글이 있으면 board 객체 넘겨주기 
//			System.out.println(board);
			
			request.setAttribute("board", board);
			request.getRequestDispatcher("/views/board/view.jsp").forward(request, response);
		} else {
			// 없는 게시글일 경우 alert 창 띄우기 해보기
			request.setAttribute("msg", "없는 게시글입니다.");
			request.setAttribute("location", "/board/list");
			
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
	
	}

}
