package com.spring.cosa.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.cosa.common.utils.S3Upload;
import com.spring.cosa.user.dto.JoinDTO;
import com.spring.cosa.user.dto.LoginDTO;
import com.spring.cosa.user.dto.ProfileDTO;
import com.spring.cosa.user.dto.SmsDTO;
import com.spring.cosa.user.exception.ValidationSequence;
import com.spring.cosa.user.service.JoinService;
import com.spring.cosa.user.service.LoginService;
import com.spring.cosa.user.service.ProfileService;

import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Controller
public class UserController {

	@Autowired
	private JoinService joinService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private ProfileService profileService;
	
	//@Autowired
	//private S3Upload s3Upload;

	// 유저 회원가입
	@GetMapping("/user/join")
	public void join() {}

	@ResponseBody
	@PostMapping("/user/join")
	public Map<String, Object> joinProc(@Validated(ValidationSequence.class) @RequestBody JoinDTO dto) {

		Map<String, Object> val = new HashMap<String, Object>();
		val.put("result", joinService.joinProc(dto));

		return val;
	}

	// 유저 로그인
	@GetMapping("/user/login")
	public void login() {
	}

	@ResponseBody
	@PostMapping("/user/loginProc")
	public Map<String, Object> loginProc(@Validated(ValidationSequence.class) @RequestBody LoginDTO dto) {

		Map<String, Object> val = new HashMap<String, Object>();
		val.put("result", loginService.loginProc(dto));

		return val;
	}

	// 회원정보 관리
	@GetMapping("/user/profile")
	public ModelAndView info() throws IOException {
		return profileService.showMainProfile();
	}
	
	// 회원이름 변경
	@ResponseBody
	@PostMapping("/user/profile/modifyNm")
	public Map<String, Object> modifyProfileNm(@Validated(ValidationSequence.class) @RequestBody ProfileDTO dto) {

		Map<String, Object> val = new HashMap<String, Object>();
		val.put("data", profileService.modifyProfileNm(dto));

		return val;
	}

	// 회원휴대번호 변경
	@ResponseBody
	@PostMapping("/user/profile/modifyPh")
	public Map<String, Object> modifyProfilePh(@Validated(ValidationSequence.class) @RequestBody ProfileDTO dto) {

		Map<String, Object> val = new HashMap<String, Object>();
		val.put("data", profileService.modifyProfilePh(dto));

		return val;
	}
	
	// sms 문자 인증
	@ResponseBody
	@PostMapping("/user/sms")
	public Map<String, Object> getSmsCode(@Validated(ValidationSequence.class) @RequestBody SmsDTO dto) throws CoolsmsException {
		
		Map<String, Object> val = new HashMap<String, Object>();
		val.put("authCode", joinService.sendSms(dto));

		return val;
	}

	@ResponseBody
	@PostMapping("/user/profile/insProfileImg")
	public void insProfileImg(MultipartHttpServletRequest req) throws IOException {

		List<MultipartFile> fileList = req.getFiles("files");
		
		System.out.println(fileList);
		System.out.println(fileList.get(0).getOriginalFilename());
		System.out.println(fileList.get(1).getOriginalFilename());

		/*
		String aa = s3Upload.upload(file);
		System.out.println(aa);
		
		System.out.println(file);
		System.out.println(file.getContentType());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getName());
		System.out.println(file.getSize());
		System.out.println(file.getBytes());
	*/
		//return profileService.insProfileImg(req);
	}
	
	
}





