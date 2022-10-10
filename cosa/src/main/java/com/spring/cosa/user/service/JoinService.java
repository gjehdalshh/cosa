package com.spring.cosa.user.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.cosa.common.utils.RandomNumberGenerator;
import com.spring.cosa.user.dto.JoinDTO;
import com.spring.cosa.user.dto.SmsDTO;
import com.spring.cosa.user.mapper.UserMapper;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
public class JoinService {
	
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Value("${api_sms_key}")
	private String api_key;
	
	@Value("${api_sms_secret}")
	private String api_secret;
	
	@Value("${send_phone}")
	private String send_phone;
	
	public int joinProc(JoinDTO dto) {
		if(mapper.selectId(dto.getUser_id()) != null) {
			return 2;
		}
		if(mapper.selectPh(dto.getUser_phone()) != null) {
			return 3;
		}
		if(!dto.getAuthCode().equals(dto.getAuthCodeCheck())) {
			return 4;
		}
		
		dto.setUser_pw(bcrypt.encode(dto.getUser_pw()));
		
		return mapper.insUser(dto);
	}
	
	public String sendSms(SmsDTO dto) throws CoolsmsException {
		
		Message coolsms = new Message(api_key, api_secret);
		
		HashMap<String, String> sms = new HashMap<String, String>();
		
		String authCode = RandomNumberGenerator.get_5_randomNumber();
		
		sms.put("to", dto.getUser_phone());
		sms.put("from", send_phone);
		sms.put("type", "SMS");
		sms.put("text", authCode);
		
		coolsms.send(sms);
		
		return authCode;
	}
	
}
