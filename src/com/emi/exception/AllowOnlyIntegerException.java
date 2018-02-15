package com.emi.exception;

public class AllowOnlyIntegerException extends Exception{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Only Integer Values Allowed";
	}
}
