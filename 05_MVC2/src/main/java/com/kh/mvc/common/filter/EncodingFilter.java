package com.kh.mvc.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/*
 * 서블릿 필터
 * 		- request, response가 서블릿이나 JSP등에 도달하기 전에 필요한 전/후 처리 작업을 실행한다.
 * 		- FilterChain을 통해서 여러 개의 필터를 연속적으로 사용 가능하다.
 * 
 * 필터를 등록하는 방법
 * 		- WEB-INF/web.xml 파일에 필터를 등록해서 사용한다.
 * 		- @WebFilter 어노테이션으로 필터를 등록해서 사용한다. (<- 우린 이 방법 사용)
 */


@WebFilter(filterName = "encoding", urlPatterns="/*")
public class EncodingFilter implements Filter {
       
    public EncodingFilter() {
    }

    @Override
	public void init(FilterConfig fConfig) throws ServletException {
		// 필터가 생성된 다음에 필터를 초기화하기 위해 사용
    	// 컨테이너가 필터를 생성 후 초기화를 위해서 호출한
    	System.out.println("Enocoding 필터가 생성되어 초기화 진행");
	}
	
    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 컨테이너가 현재 요청에 필터를 적용하겠다고 판단하면 호출된다.
    	System.out.println("doFilter() 메소드 실행");
    	
    	HttpServletRequest hr = (HttpServletRequest)request;
    	
    	// 사용자 요청방식이 POST이면 UTF-8로 인코딩하겠다!
    	if (hr.getMethod().equals("POST")) {
    		hr.setCharacterEncoding("UTF-8");
    		
    		System.out.println(hr.getCharacterEncoding() + " 인코딩 완료");
    	}
    	
    	
    	// 다음 필터를 호출하거나, 서블릿, JSP를 호출한다.
		chain.doFilter(request, response);
		
		
	}
	
    @Override
	public void destroy() {
    	// 컨테이너가 필터를 제거할 때 호출한다.
    	System.out.println("Enocoding 필터가 소멸됨");
	}

}
