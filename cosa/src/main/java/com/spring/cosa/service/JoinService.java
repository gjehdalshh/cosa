package com.spring.cosa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cosa.controller.dto.JoinDTO;
import com.spring.cosa.mapper.UserMapper;

@Service
public class JoinService {
	
	@Autowired
	private UserMapper mapper;
	
	public JoinDTO home(JoinDTO dto) {
		return mapper.home(dto);
	}
}
