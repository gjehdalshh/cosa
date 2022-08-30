package com.spring.cosa.common;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class SessionCheckFilter implements Filter{

	private List<String> excludeUrls;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//String excludePattern = filterConfig.getInitParameter("excludeUrls");
		//excludeUrls = Arrays.asList(excludePattern.split(","));
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("테스트");
		
		//String path = ((HttpServletRequest)request).getServletPath();
		
		//if(excludeUrls.contains(path)) {
		//	System.out.println("확인");
		//}
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
		
	}

}
