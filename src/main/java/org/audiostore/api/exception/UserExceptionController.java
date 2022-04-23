package org.audiostore.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionController {
	
	@ExceptionHandler(value= UserNotFoundException.class)
	public ResponseEntity<Object> exception (UserNotFoundException exception){
		return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		
	}

}
