package com.kh.mvc.board.controller;

import java.io.File;
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
    	
    	
    	
    	// 220725 1교시때 작성한 내용 
    	// 업로드하는 파일이 없으면 mutlipartrequest에 전달 혹은 존재하는 내용 없음!
    	String originalFileName = mr.getOriginalFileName("upfile");
    	String filesystemName = mr.getFilesystemName("upfile");
    	
    	System.out.println(originalFileName);
    	System.out.println(filesystemName);
    	
    	// 사용자가 파일을 upload하면~ 조건문 
    	if (originalFileName != null && !originalFileName.equals("")) {
    		// 파일이 수정되면 기존 파일 삭제하는 로직
    		// 실무에서는 임시 폴더로 옮기도록 세팅하구 정기적으로 삭제한다.
    		File file = new File(path + "/" + mr.getParameter("renamedFileName"));
    		
    		if (file.exists()) {
				file.delete();
			}
    		
    		board.setOriginalFileName(originalFileName);
        	board.setRenamedFileName(filesystemName);
    	} else {
    		board.setOriginalFileName(mr.getParameter("originalFileName"));
        	board.setRenamedFileName(mr.getParameter("renamedFileName"));
    	}
    	
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
