package com.radu.test.spring.store.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.radu.test.spring.store.service.OrderService;

@ControllerAdvice(assignableTypes = OrderService.class)
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger log = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);
	@ExceptionHandler(value 
		      = { IllegalArgumentException.class, IllegalStateException.class, NullPointerException.class })
		    protected ResponseEntity<Object> handleConflict(
		      RuntimeException ex, WebRequest request) {
				log.error("Internal order server error.",ex);
		        String bodyOfResponse = "Internal order service error!";
		        return handleExceptionInternal(ex, bodyOfResponse, 
		          new HttpHeaders(), HttpStatus.CONFLICT, request);
		    }
	
}
