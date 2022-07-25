package com.kh.mvc.board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/fileDown")
public class FileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public FileDownServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oname = request.getParameter("oname"); // originalFileName
		String rname = request.getParameter("rname"); // renamedFileName
		
		System.out.println(oname + ", " + rname);
		
		// 1. 클라이언트로 전송할 파일의 경로와 파일명을 가져온다 .
		// 실제로 저장될 경로 + renamedFileName 
		String filePath = getServletContext().getRealPath("/resources/upload/board") + "/" + rname;
		
//		System.out.println(filePath);
		
		// 2. 물리적인 경로에 저장되어 있는 파일을 메모리로 가져온다.
		// File 객체를 통해서 메모리를 읽어온다.
		File downFile = new File(filePath);
		
		// 3. 메모리로 가져온 파일에 입력 스트림을 연결
		// 성능향상보조 스트림으로 사용 -> 기반 스트림이 반드시 필요하다 
//		FileInputStream is = new FileInputStream(downFile);
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
		
		// 4. 클라이언트로 내보낼 출력 스트림을 연결
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		
		// 5. 브라우저별 인코딩 처리
		String downFileName = null;
		String userAgent = request.getHeader("user-agent");
		
		boolean isMSIE = userAgent.indexOf("MSIE") != -1 || userAgent.indexOf("Trident") != -1;
		
		// IE는 인코딩을 통해서 파일명을 내려줘야하기 떄문에 아래와 같은 코드를 작성한다! 
		if(isMSIE) {
			downFileName = URLEncoder.encode(oname, "UTF-8").replaceAll("\\+", "%20"); // 파일명에 공백이 있으면 오류가 생기지 않도록! 
		} else {
			downFileName = new String(oname.getBytes("UTF-8"), "ISO-8859-1");
		}
		
		// 6. 응답 메세지 작성 (html X, file O)
		// html의 경우
//		response.setContentType("text/html");
		// application/octet-stream : 모든 종류의 2진 데이터를 뜻한다.
		response.setContentType("application/octet-stream"); // MINE 형태
		// 파일 링크를 클릭했을 때 다운로드 화면이 출력되게 처리하는 부분 (하얀화면이 아니라 아래에 뜨게)
		response.setHeader("Content-Disposition", "attachment;filename=" + downFileName);
		
		// 7. 마지막 단계! 파일 클라이언트로 출력(전송) 하기
		int read = -1;
		
		// 먼저 bis를 통해서 byte값을 읽어오고 
		while((read = bis.read()) != -1) {
			// -1 이 아니면..
			bos.write(read);
			
		}
		
		// Stream 닫기 
		bos.close();
		bis.close();
		
		
		
	}

}
