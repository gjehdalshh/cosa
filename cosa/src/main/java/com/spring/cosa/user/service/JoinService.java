package com.spring.cosa.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cosa.user.dao.UserDAO;
import com.spring.cosa.user.dto.JoinDTO;
import com.spring.cosa.user.mapper.UserMapper;

@Service
public class JoinService {
	
	@Autowired
	private UserMapper mapper;
	
	public int joinProc(JoinDTO dto) {
		if(mapper.selectId(dto.getUser_id()) == 1) {
			return 2;
		}
		if(mapper.selectPh(dto.getUser_phone()) == 1) {
			return 3;
		}
		return mapper.insUser(dto);
	}
}
