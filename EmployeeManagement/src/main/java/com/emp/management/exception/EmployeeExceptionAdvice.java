package com.emp.management.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionAdvice extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(EmployeeExistException.class)
	public final ResponseEntity<Object> handleEmpExistException(EmployeeExistException ex, WebRequest request) {
	    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleEmpNotFoundException(EmployeeNotFoundException ex, WebRequest request) {
		 ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
			        request.getDescription(false),HttpStatus.NOT_FOUND.toString());
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	    
}
