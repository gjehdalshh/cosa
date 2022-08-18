package com.spring.cosa.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.cosa.common.Util;


@ControllerAdvice
public class ValidationExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        ErrorResponse errorResponse = new ErrorResponse();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        errorResponse.setStatus(status.value());
        errorResponse.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        errorResponse.setTimestamp(Util.formatDate());
        
        return new ResponseEntity<ErrorResponse>(errorResponse, status);
    }
}
