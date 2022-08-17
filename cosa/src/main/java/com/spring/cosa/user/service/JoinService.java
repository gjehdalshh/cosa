package com.spring.cosa.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cosa.user.dao.JoinDAO;
import com.spring.cosa.user.dto.JoinDTO;
import com.spring.cosa.user.mapper.UserMapper;

@Service
public class JoinService {
	
	@Autowired
	private UserMapper mapper;
	
	public JoinDAO join(JoinDTO dto) {
		return mapper.join(dto);
	}
}
