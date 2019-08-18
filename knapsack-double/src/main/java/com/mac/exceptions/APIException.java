package com.mac.exceptions;

public class APIException extends Exception {

	private static final long serialVersionUID = 1L;

	public APIException(String errorMessage) {
		super(errorMessage);
	}

}
