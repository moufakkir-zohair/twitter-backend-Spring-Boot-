package com.twitter.component.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value= {UserNotExistsException.class})
	public ResponseEntity<Object> HandleUserNotExistsException(UserNotExistsException ex , WebRequest request){
		MessageException message = new MessageException(ex.getMessage());
		return new ResponseEntity<Object>(message ,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(value= {UserAlreadyExistsException.class})
	public ResponseEntity<Object> HandleUserAlreadyExistsException(UserAlreadyExistsException ex , WebRequest request){
		MessageException message = new MessageException(ex.getMessage());
		return new ResponseEntity<Object>(message,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
