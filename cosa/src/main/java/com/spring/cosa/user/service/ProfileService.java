package com.spring.cosa.user.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.spring.cosa.user.dao.UserDAO;
import com.spring.cosa.user.dto.LoginDTO;
import com.spring.cosa.user.dto.ProfileDTO;
import com.spring.cosa.user.mapper.UserMapper;

@Service
public class ProfileService {

	@Autowired
	private UserMapper mapper;

	@Autowired
	private HttpSession session;

	public ModelAndView showMainProfile() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/profile");
		mv.addObject("data", selectProfile());

		return mv;
	}

	private UserDAO selectProfile() {

		LoginDTO dto = (LoginDTO) session.getAttribute("user");
		UserDAO vo = mapper.selectId(dto.getUser_id());

		return vo;
	}

	public int modifyProfileNm(ProfileDTO dto) {
		return mapper.modifyProfileNm(dto);
	}

	public int modifyProfilePh(ProfileDTO dto) {
		return mapper.modifyProfilePh(dto);
	}
}
