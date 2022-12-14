package com.spring.cosa.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.spring.cosa.user.exception.ValidationGroups;
import com.sun.istack.NotNull;

public class JoinDTO {
	@NotBlank(message = "아이디를 입력해주세요", groups = ValidationGroups.NotBlankGroup.class)
	@Email(message = "아이디를 이메일 형식으로 작성해주세요.", groups = ValidationGroups.EmailCheckGroup.class)
	private String user_id;
	
	@NotBlank(message = "비밀번호를 입력해주세요", groups = ValidationGroups.NotBlankGroup.class)
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "비밀번호는 8자 이상 영문과 숫자를 포함해주세요.", groups = ValidationGroups.PatternCheckGroup.class)
	private String user_pw;
	
	@NotBlank(message = "이름을 입력해주세요", groups = ValidationGroups.NotBlankGroup.class)
	@Size(min = 2, max = 4, message = "이름은 2 ~ 4자여야 합니다.", groups = ValidationGroups.SizeCheckGroup.class)
	private String user_nm;
	
	@NotBlank(message = "전화번호를 입력해주세요", groups = ValidationGroups.NotBlankGroup.class)
	@Size(min = 11, max = 11, message = "전화번호는 11자여야 합니다.", groups = ValidationGroups.SizeCheckGroup.class)
	private String user_phone;
	
	//@NotBlank(message = "주민번호를 입력해주세요", groups = ValidationGroups.NotBlankGroup.class)
	//@Size(min = 13, max = 13, message = "주민번호는 13자여야 합니다.", groups = ValidationGroups.SizeCheckGroup.class)
	private int user_regNo;
	
	@NotNull
	@Size(min = 5, max = 5, message = "보안코드는 5자여야 합니다..", groups = ValidationGroups.SizeCheckGroup.class)
	private String authCode;
	
	private String authCodeCheck;

	public String getAuthCodeCheck() {
		return authCodeCheck;
	}

	public void setAuthCodeCheck(String authCodeCheck) {
		this.authCodeCheck = authCodeCheck;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public int getUser_regNo() {
		return user_regNo;
	}

	public void setUser_regNo(int user_regNo) {
		this.user_regNo = user_regNo;
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

	public String getUser_nm() {
		return user_nm;
	}

	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
}
