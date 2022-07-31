package com.ty.hospital.hospitalappboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HospitalAppExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> handleIdNotFoundException(IdNotFoundException idnotfoundexception) {
		String message = idnotfoundexception.getMessage();
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
		return responseEntity;
	}
}

