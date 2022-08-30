package com.spring.cosa.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.spring.cosa.user.entity.UserEntity;
import com.spring.cosa.user.exception.ValidationGroups;

public class LoginDTO extends UserEntity {
	
	private int i_user;

	@NotBlank(message = "아이디를 입력해주세요.", groups = ValidationGroups.NotBlankGroup.class)
	@Email(message = "아이디를 이메일 형식으로 작성해주세요.", groups = ValidationGroups.EmailCheckGroup.class)
	private String user_id;
	
	@NotBlank(message = "비밀번호를 입력해주세요", groups = ValidationGroups.NotBlankGroup.class)
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "비밀번호는 8자 이상 영문과 숫자를 포함해주세요.", groups = ValidationGroups.PatternCheckGroup.class)
	private String user_pw;
	
	public int getI_user() {
		return i_user;
	}

	public void setI_user(int i_user) {
		this.i_user = i_user;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
}
