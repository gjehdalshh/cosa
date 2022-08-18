package com.spring.cosa.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.cosa.user.dto.JoinDTO;
import com.spring.cosa.user.entity.UserEntity;
import com.spring.cosa.user.service.JoinService;

@Controller
public class UserController {

	@Autowired
	private JoinService service;
	
	// 유저 로그인
	@GetMapping("/user/login")
	public void login() {
		
	}
	
	@GetMapping("/user/join")
	public void join() {}
	
	@ResponseBody
	@PostMapping("/user/joinProc")
	public Map<String, Object> join(@Valid @RequestBody JoinDTO dto) {
		Map<String, Object> val = new HashMap<String, Object>();
		
		val.put("result", dto.getUser_nm());
		
		return val;
	}

}
