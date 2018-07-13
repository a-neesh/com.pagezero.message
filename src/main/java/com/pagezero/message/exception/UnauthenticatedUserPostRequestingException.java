package com.pagezero.message.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UnauthenticatedUserPostRequestingException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6414210015655987778L;
	public UnauthenticatedUserPostRequestingException (String message) {
		super(message);
	}
	public UnauthenticatedUserPostRequestingException (String message, Throwable cause) {
		super(message, cause);
	}
}
