package com.spring.cosa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.cosa.controller.dto.JoinDTO;
import com.spring.cosa.service.JoinService;

@Controller
public class UserController {

	@Autowired
	private JoinService service;
	
	@GetMapping("/home")
	public void home(Model model, JoinDTO dto) {
		model.addAttribute("data", service.home(dto));
	}
}
