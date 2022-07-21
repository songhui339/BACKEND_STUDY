package com.kh.mvc.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		
		System.out.println("게시글 번호 : " + no);
		
//		조회한 객체를 board에 전달
		board = new BoardService().getBoardByNo(no);
		
		
//		request.setAttribute("board", board);
//		request.getRequestDispatcher("/views/board/view.jsp").forward(request, response);
		
		
		if(board != null) {
			// 게시글이 있으면 board 객체 넘겨주기 
			System.out.println(board);
			
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
