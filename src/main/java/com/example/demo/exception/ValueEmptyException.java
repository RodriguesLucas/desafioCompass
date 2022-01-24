package com.example.demo.exception;

public class ValueEmptyException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ValueEmptyException(String message) {
		super(message);
	}
}
