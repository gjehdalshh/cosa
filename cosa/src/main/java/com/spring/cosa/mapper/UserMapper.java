package com.spring.cosa.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.spring.cosa.controller.dto.JoinDTO;

@Mapper
public interface UserMapper {
	JoinDTO home(JoinDTO dto);
}
