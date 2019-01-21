package com.when.shiro.exception;

import com.when.shiro.dto.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: when
 * @create: 2018-11-07  10:10
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(GlobalException.class)
	public ResponseData handleGlobalException(GlobalException e) {
		ResponseData response = new ResponseData();
		response.setCode(e.getCode());
		response.setMsg(e.getMsg());
		logger.debug("Response is: " + response);
		return response;
	}

}
