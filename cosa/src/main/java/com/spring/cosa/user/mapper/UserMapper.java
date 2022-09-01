package com.spring.cosa.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.spring.cosa.user.dao.UserDAO;
import com.spring.cosa.user.dto.JoinDTO;
import com.spring.cosa.user.dto.ProfileDTO;

@Mapper
public interface UserMapper {
	int insUser(JoinDTO dto);
	int modifyProfileNm(ProfileDTO dto);
	int modifyProfilePh(ProfileDTO dto);
	UserDAO selectId(String id);
	UserDAO selsectPw(String pw);
	UserDAO selectPh(String ph);
}
