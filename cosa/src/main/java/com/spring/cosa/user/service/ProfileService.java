package com.spring.cosa.user.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.spring.cosa.user.dao.UserDAO;
import com.spring.cosa.user.dto.LoginDTO;
import com.spring.cosa.user.mapper.UserMapper;

@Service
public class ProfileService {

	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private HttpSession session;
	
	public ModelAndView mainProfile() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/profile");
		mv.addObject("data", selectProfile());
		
		return mv;
	}
	
	public UserDAO selectProfile() {
		
		if(session.getAttribute("user") == null) {
			System.out.println("null test");
		}
		
		LoginDTO dto = (LoginDTO)session.getAttribute("user");
		UserDAO vo = mapper.selectId(dto.getUser_id());
		
		return vo;
	}
}
