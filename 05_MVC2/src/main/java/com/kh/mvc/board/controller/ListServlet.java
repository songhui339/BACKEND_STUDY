package com.kh.mvc.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mvc.board.model.service.BoardService;
import com.kh.mvc.board.model.vo.Board;
import com.kh.mvc.common.util.PageInfo;


@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ListServlet() {
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 0;
		int listCount = 0;
		PageInfo pageInfo = null;
//		리스트로 조회되는 하나하나를 Board 객체로 만들어 List객체 담을거다!
		List<Board> list = null;
		
		/**
		 * 
		 * currentPage 현재 페이지 : page
		 * pageLimit 한 페이지에 보이는 페이지의 수  : 10
		 * listCount 전체 리스트의 수 : listCount
		 * listLimit 한 페이지에 표시될 리스트의 수 : 10
		 * 
		 * 그럼 나머지 데이터는 ?!
		 * 
		 */
		// 파라미터의 기본 값을 1로 세팅 -> 예외 처리 
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch(NumberFormatException e) {
			page = 1;
		}
		
		listCount = new BoardService().getBoardCount();
		pageInfo = new PageInfo(page, 10, listCount, 10);
		// 데이터베이스에 조회되는 행 하나하나를 Board 객체로 만들어 List 객체에 담아주는 것!
		list = new BoardService().getBoardList(pageInfo);
		
		System.out.println(list);
		
//		System.out.println(pageInfo.getCurrentPage());
//		System.out.println(listCount);
//		System.out.println(pageInfo.getMaxPage());
//		System.out.println(pageInfo.getStartPage());
//		System.out.println(pageInfo.getEndPage());
//		System.out.println(pageInfo.getNextPage());
//		System.out.println(pageInfo.getPrevPage());
		
		request.setAttribute("pageInfo", pageInfo);
		
		request.getRequestDispatcher("/views/board/list.jsp").forward(request, response);
	}

}
