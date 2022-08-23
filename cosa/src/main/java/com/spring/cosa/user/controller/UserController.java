package com.spring.cosa.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.cosa.user.dto.JoinDTO;
import com.spring.cosa.user.dto.LoginDTO;
import com.spring.cosa.user.exception.ValidationSequence;
import com.spring.cosa.user.service.JoinService;
import com.spring.cosa.user.service.LoginService;

@Controller
public class UserController {

	@Autowired
	private JoinService joinService;
	
	@Autowired
	private LoginService loginService;

	@GetMapping("/user/join")
	public void join() {}

	@ResponseBody
	@PostMapping("/user/joinProc")
	public Map<String, Object> joinProc(@Validated(ValidationSequence.class) @RequestBody JoinDTO dto) {
		Map<String, Object> val = new HashMap<String, Object>();

		val.put("result", joinService.joinProc(dto));

		return val;
	}

	// 유저 로그인
	@GetMapping("/user/login")
	public void login() {}
	
	@ResponseBody
	@PostMapping("/user/loginProc")
	public Map<String, Object> loginProc(@Validated(ValidationSequence.class) @RequestBody LoginDTO dto) {
		Map<String, Object> val = new HashMap<String, Object>();
		System.out.println("테스");
		val.put("result", loginService.loginProc(dto));
		
		return val;
	}
}


