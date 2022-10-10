package com.spring.cosa.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.spring.cosa.user.exception.ValidationGroups;

public class SmsDTO {
	@NotBlank(message = "전화번호를 입력해주세요", groups = ValidationGroups.NotBlankGroup.class)
	@Size(min = 11, max = 11, message = "전화번호는 11자여야 합니다.", groups = ValidationGroups.SizeCheckGroup.class)
	private String user_phone;

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	
}
