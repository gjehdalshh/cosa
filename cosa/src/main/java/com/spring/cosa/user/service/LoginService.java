package com.spring.cosa.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.cosa.user.dao.UserDAO;
import com.spring.cosa.user.dto.LoginDTO;
import com.spring.cosa.user.mapper.UserMapper;

@Service
public class LoginService {

	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpSession session;
	
	public int loginProc(LoginDTO dto) {
		UserDAO vo = mapper.selectId(dto.getUser_id());
		
		if(vo == null) {
			return 2;
		} 
		if(!idPasswordCheck(dto)) {
			return 3;
		}
		
		dto.setI_user(vo.getI_user());
		session = request.getSession(true);
		session.setAttribute("user", dto);
		
		return 1;
	}
	
	private boolean idPasswordCheck(LoginDTO dto) {
		UserDAO vo = mapper.selectId(dto.getUser_id());
		
		if(!bcrypt.matches(dto.getUser_pw(), vo.getUser_pw())) {
			return false;
		}
		return true;
	}
}


