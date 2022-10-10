package com.spring.cosa.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.spring.cosa.user.entity.UserEntity;
import com.spring.cosa.user.exception.ValidationGroups;

public class ProfileDTO {
	
	private int i_user;
	
	@NotBlank(message = "이름을 입력해주세요", groups = ValidationGroups.NotBlankGroup.class)
	@Size(min = 2, max = 4, message = "이름은 2 ~ 4자여야 합니다.", groups = ValidationGroups.SizeCheckGroup.class)
	private String User_nm;
	
	@NotBlank(message = "전화번호를 입력해주세요", groups = ValidationGroups.NotBlankGroup.class)
	@Size(min = 11, max = 11, message = "전화번호는 11자여야 합니다.", groups = ValidationGroups.SizeCheckGroup.class)
	private String User_phone;

	public int getI_user() {
		return i_user;
	}

	public void setI_user(int i_user) {
		this.i_user = i_user;
	}

	public String getUser_nm() {
		return User_nm;
	}

	public void setUser_nm(String user_nm) {
		User_nm = user_nm;
	}

	public String getUser_phone() {
		return User_phone;
	}

	public void setUser_phone(String user_phone) {
		User_phone = user_phone;
	}
	
	
}
