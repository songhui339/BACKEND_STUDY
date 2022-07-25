package com.kh.mvc.board.controller;

import java.io.IOException;
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
	}

}
