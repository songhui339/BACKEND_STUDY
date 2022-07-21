package com.kh.mvc.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mvc.board.model.service.BoardService;
import com.kh.mvc.board.model.vo.Board;
import com.kh.mvc.common.util.FileRename;
import com.oreilly.servlet.MultipartRequest;


@WebServlet(name = "BoardUpdateServlet", urlPatterns = { "/board/update" })
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public UpdateServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 로그인 체크 & 본인 게시글 여부 확인 해야함 (직접 구현해보기)
    	Board board = null;
    	int no = Integer.parseInt(request.getParameter("no"));
    	
    	System.out.println("게시글 번호 : " + no);
		
//		조회한 객체를 board에 전달
		board = new BoardService().getBoardByNo(no);
		
		request.setAttribute("board", board);
		request.getRequestDispatcher("/views/board/update.jsp").forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Board board = null;
		int result = 0;
		// 로그인 체크 & 본인 게시글 여부 확인 해야함 (직접 구현해보기)
		
		// 파일이 저장될 경로  -> 우리는 프로젝트내부의 폴더에 저장
    	String path = getServletContext().getRealPath("/resources/upload/board");
    	
    	// 파일의 최대 사이즈 지정 (MAX 10MB)
    	int maxSize = 10485760;
    	
    	// 인코딩 설정 
    	String encoding = "UTF-8";
    	
    	// DefaultFileRenamePolicy: 중복되는 이름 뒤에 1 ~ 9999 붙인다.
    	MultipartRequest mr = new MultipartRequest(request, path, maxSize, encoding, new FileRename());
    	
    	board = new Board();
    	
    	board.setNo(Integer.parseInt(mr.getParameter("no")));
    	board.setTitle(mr.getParameter("title"));
    	board.setWriterId(mr.getParameter("writer"));
    	board.setContent(mr.getParameter("content"));
    	
    	board.setOriginalFileName(mr.getParameter("originalFileName"));
    	board.setRenamedFileName(mr.getParameter("renamedFileName"));
    	
    	result = new BoardService().save(board);
    	
    	if(result > 0 ) {
    		request.setAttribute("msg", "게시글 수정 성공");
    	} else {
    		request.setAttribute("msg", "게시글 수정 실패");
    	}
    	request.setAttribute("location", "/board/view?no=" + board.getNo());
    	request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

}
