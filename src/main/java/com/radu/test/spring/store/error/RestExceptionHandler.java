package com.radu.test.spring.store.error;

import java.util.Date;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorData> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorData errorDetails = new ErrorData(new Date(), ex.getMessage(), request.getDescription(false),"500 Internal Server Error");
		log.error("An exception has occured!", ex);
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public final ResponseEntity<ErrorData> handleUserNotFoundException(NoSuchElementException ex, WebRequest request) {
		ErrorData errorDetails = new ErrorData(new Date(), ex.getMessage(), request.getDescription(false),"404 Not Found");
		log.error("Element nof found exception has occured!", ex);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
