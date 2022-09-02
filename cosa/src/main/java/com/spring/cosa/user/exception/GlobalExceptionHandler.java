package com.spring.cosa.user.exception;

import java.io.IOException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NullPointerException.class)
	protected String npeHandler(RedirectAttributes redirect){
       
		redirect.addAttribute("error", "세션이 만료되었습니다.");
		
        return "redirect:/user/login";
    }
	
	@ExceptionHandler(IOException.class)
	protected ModelAndView IoeHandler() {
		
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
}
