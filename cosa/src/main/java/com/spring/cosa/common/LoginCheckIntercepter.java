package com.spring.cosa.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.cosa.user.dto.LoginDTO;

public class LoginCheckIntercepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(isAjaxRequest(request)) {
			return true;
		}
		// false : 세션이 없으면 null, true : 세션이 없으면 생성
		HttpSession session = request.getSession(false);
		LoginDTO dto = (LoginDTO) session.getAttribute("user");
		if (session == null || dto == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 이후에 사용해주세요.'); location.href='/user/login';</script>");
			out.flush();
			return false;
		}
		return true;
	}
	
	private boolean isAjaxRequest(HttpServletRequest request) {
		
		String header = request.getContentType();
		
		if("application/json".equals(header)) {
			return true;
		}
		return false;
	}
}
