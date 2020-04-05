package com.evolenthealth.contactdetails.exception;

public class ExceptionResponse {
	private String message;
	private String Details;
	
	
	public ExceptionResponse(String message, String details) {
		super();
		this.message = message;
		Details = details;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	
	
	
}
