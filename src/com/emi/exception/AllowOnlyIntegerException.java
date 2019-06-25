package com.emi.exception;


/** 
	@author : amaresh bonam
	
*/
public class AllowOnlyIntegerException extends Exception{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Only Integer Values Allowed";
	}
	
	public void temp() {
		//just dummy method
		// this for AR-1
	}
	
	
}
