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

import com.kh.mvc.common.wrapper.EncryptPasswordWrapper;

// 파라미터 값의 암호화를 진행할 것임
@WebFilter( filterName = "encrypt", servletNames = { "EnrollServlet", "LoginServlet"})
public class EncryptFilter implements Filter {
       
    public EncryptFilter() {
    }
    
	
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    	
    }
    
    
    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
    	// request 객체의 파리미터 값을 직접 변경할 수 없기 때문에 (즉 재정의 불가) wrapper 클래스를 생성해서 파라미터 값을 수정한다!
    	EncryptPasswordWrapper wrapper = new EncryptPasswordWrapper((HttpServletRequest)request);
    	
    	
    	
		chain.doFilter(wrapper, response);
	}
    
    
    @Override
    public void destroy() {
    	
    }

}
