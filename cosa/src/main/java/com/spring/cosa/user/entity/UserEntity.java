package com.spring.cosa.user.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.spring.cosa.user.exception.ValidationGroups;

public class UserEntity {
	
	private int i_user;
	
	@NotEmpty(message = "아이디를 입력해주세요", groups = ValidationGroups.NotEmptyGroup.class)
	@Email(message = "아이디를 이메일 형식으로 작성해주세요.", groups = ValidationGroups.EmailCheckGroup.class)
	private String user_id;
	
	@NotEmpty(message = "비밀번호를 입력해주세요", groups = ValidationGroups.NotEmptyGroup.class)
	@Pattern(regexp="^[a-zA-Z0-9]*$", message = "비밀번호는 영문과 숫자를 포함해주세요.", groups = ValidationGroups.PatternCheckGroup.class)
	private String user_pw;
	
	@NotEmpty(message = "이름을 입력해주세요", groups = ValidationGroups.NotEmptyGroup.class)
	@Size(min = 2, max = 4, message = "이름은 2 ~ 4자여야 합니다.", groups = ValidationGroups.SizeCheckGroup.class)
	private String user_nm;
	
	@NotEmpty(message = "전화번호를 입력해주세요", groups = ValidationGroups.NotEmptyGroup.class)
	@Size(min = 11, max = 11, message = "전화번호는 11자여야 합니다.", groups = ValidationGroups.SizeCheckGroup.class)
	private String user_phone;
	private String r_dt;
	private int authority;
	
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
	public String getR_dt() {
		return r_dt;
	}
	public void setR_dt(String r_dt) {
		this.r_dt = r_dt;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	
}
