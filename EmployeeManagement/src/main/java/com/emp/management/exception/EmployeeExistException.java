package com.emp.management.exception;

public class EmployeeExistException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeExistException(String message){
		super(message);
	}

}
