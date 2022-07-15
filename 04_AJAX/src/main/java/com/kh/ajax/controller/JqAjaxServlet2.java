package com.kh.ajax.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.ajax.model.vo.User;

@WebServlet("/jqAjax2.do")
public class JqAjaxServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public JqAjaxServlet2() {
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		// 사용자 정보가 저장되어 있는 List 객체 생성(가라 데이터)
		List<User> list = new ArrayList<>();
		
		list.add(new User(1, "이슬기", 31, "남자"));
		list.add(new User(2, "최송희", 29, "여자"));
		list.add(new User(3, "이정후", 25, "남자"));
		list.add(new User(4, "영심이", 16, "여자"));
		list.add(new User(5, "안경태", 16, "남자"));
		
		User findUser = list.stream()
							.filter(user -> user.getNo() == userNo)
							.findFirst()
							.orElse(null);
		
		System.out.println(findUser);
		// 오...여기서부터 어렵다 복습 필수
		System.out.println(new Gson().toJson(findUser));
		// git 에서 복사해오기 (너무 어렵 ㅜㅠ)
//		System.out.println(new Gson().fromJson("{\"no\":" + 5 , "\"name\": \"이정후\"}", null));
		
		/* 
		 * Java Object를 JSON(문자열)로 바꿔줌 
		 * 클라이언트는 JSON을 JavaScript Object로 바꿔줌
		 * 
		 * 서로 사용하는 언어는 다르지만 GSON 라이브러리를 통해 통역해서 넘겨주는 것이다.
		 * 
		 * 공공데이터의 경우 JSON이나 XML 선택해서 받을 수 있도록 제공함 
		 * - GSON().toJson() : Java 객체를 JSON 문자열로 넘겨주는 메소드 
		 * - Gson().fromJson() : JSON문자열을 JAVA 객체로 넘겨주는 메소드
		 */
		
		response.setContentType("application/json;charset=UTF-8");
		
		// javaScript 객체가 아니라 문자열 (javaScript 표현식으로 작성한 ver)
		// 너무 노가다야..GSON 라이브러리 쓰자!!
//		response.getWriter().write("{\"no\":" + findUser.getNo() +  ", \"name\":" + "\"이정후\"}");
		response.getWriter().write(new Gson().toJson(findUser));
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 4) 서버에 데이터 전송 후, 응답을 리스트(List)로 받기 (JSON POSTS 방식)
		String gender = request.getParameter("gender");
		
		// 사용자 정보가 저장되어 있는 List 객체 생성(가라 데이터)
		List<User> list = new ArrayList<>();
		
		list.add(new User(1, "이슬기", 31, "남자"));
		list.add(new User(2, "최송희", 29, "여자"));
		list.add(new User(3, "이정후", 25, "남자"));
		list.add(new User(4, "영심이", 16, "여자"));
		list.add(new User(5, "안경태", 16, "남자"));
		
		List<User> findList = list.stream()
								  .filter(user -> user.getGender().equals(gender))
								  .collect(Collectors.toList());
		
		System.out.println(gender);
		System.out.println(findList);
		System.out.println(new Gson().toJson(findList));
		
		// json으로 헤더 설정해주기
		response.setContentType("application/json;charset=UTF-8");
		
		new Gson().toJson(findList, response.getWriter());
		
		
		
		
		
		
		
	}

}
