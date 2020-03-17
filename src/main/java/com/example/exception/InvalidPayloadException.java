package com.example.exception;

public class InvalidPayloadException extends Exception{
	
	public InvalidPayloadException(String errorMessage) {
		
		super(errorMessage);
	}

}
