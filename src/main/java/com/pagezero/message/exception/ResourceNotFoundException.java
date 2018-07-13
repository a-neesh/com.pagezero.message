package com.pagezero.message.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2591907043172090077L;
	public ResourceNotFoundException (String message) {
		super(message);
	}
	public ResourceNotFoundException (String message, Throwable cause) {
		super(message, cause);
	}
}
