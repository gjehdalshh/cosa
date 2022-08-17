package com.spring.cosa.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.spring.cosa.user.dao.JoinDAO;
import com.spring.cosa.user.dto.JoinDTO;

@Mapper
public interface UserMapper {
	JoinDAO join(JoinDTO dto);
}
