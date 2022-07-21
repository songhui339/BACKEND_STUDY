package com.kh.mvc.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mvc.common.util.FileRename;
import com.kh.mvc.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/board/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 로그인된 사용자인지 체크하는 로직(직접 구현해보기)
    	HttpSession session = request.getSession(false);
    	Member loginMember = (session == null) ? null : (Member) session.getAttribute("loginMember");
    	
    	if(loginMember != null) {
    		request.getRequestDispatcher("/views/board/write.jsp").forward(request, response);
    		
    	} else {
    		request.setAttribute("msg", "로그인 후  작성할 수 있습니다.");
			request.setAttribute("location", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			
    	}
    	
    	
    }
    	


    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 파일이 저장될 경로  -> 우리는 프로젝트내부의 폴더에 저장
    	String path = getServletContext().getRealPath("/resources/upload/board");
    	
    	// 파일의 최대 사이즈 지정 (MAX 10MB)
    	int maxSize = 10485760;
    	
    	// 인코딩 설정 
    	String encoding = "UTF-8";
    	
    	// DefaultFileRenamePolicy: 중복되는 이름 뒤에 1 ~ 9999 붙인다.
//    	MultipartRequest mr = new MultipartRequest(request, path, maxSize, encoding, new DefaultFileRenamePolicy());
    	MultipartRequest mr = new MultipartRequest(request, path, maxSize, encoding, new FileRename());
	}

}
