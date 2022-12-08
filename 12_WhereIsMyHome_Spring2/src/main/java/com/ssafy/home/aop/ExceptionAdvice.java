package com.ssafy.home.aop;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(DataAccessException.class)
	public String handleException(DataAccessException e) {
		return "서버 처리 오류";
	}

}