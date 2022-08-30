package com.spring.cosa.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.cosa.user.dto.JoinDTO;
import com.spring.cosa.user.mapper.UserMapper;

@Service
public class JoinService {
	
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	public int joinProc(JoinDTO dto) {
		if(mapper.selectId(dto.getUser_id()) != null) {
			return 2;
		}
		if(mapper.selectPh(dto.getUser_phone()) != null) {
			return 3;
		}
		
		dto.setUser_pw(bcrypt.encode(dto.getUser_pw()));
		
		return mapper.insUser(dto);
	}
}
