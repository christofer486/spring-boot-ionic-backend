package com.chris.cursomc.resources.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.chris.cursomc.services.exceptions.DataIntegrityException;
import com.chris.cursomc.services.exceptions.ObjectNotFoundException;

@RestControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class) 
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		StandardError error = new StandardError(NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DataIntegrityException.class) 
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request){
		
		StandardError error = new StandardError(BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.badRequest().body(error);
	}
}
 