package com.spring.cosa.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.spring.cosa.user.dao.UserDAO;
import com.spring.cosa.user.dto.JoinDTO;
import com.spring.cosa.user.entity.UserEntity;

@Mapper
public interface UserMapper {
	int insUser(JoinDTO dto);
	UserDAO selectId(String id);
	UserDAO selectPh(String ph);
}
