package com.ty.hospital.hospitalappboot.exception;

public class IdNotFoundException extends RuntimeException {
	
	private String message = "Given ID does not exist";
	
	public IdNotFoundException(){
		
	}
	
	public IdNotFoundException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
