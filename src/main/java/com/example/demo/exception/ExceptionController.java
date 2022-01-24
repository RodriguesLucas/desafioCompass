package com.example.demo.exception;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionController {
	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(RecordNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public DefaultErrorDto valueNotFoundEception(RecordNotFoundException ex, WebRequest web) {
		DefaultErrorDto message = new DefaultErrorDto(ex.getMessage());
		return message;
	}

	@ExceptionHandler(ValueEmptyException.class)
	@ResponseStatus(value = HttpStatus.LENGTH_REQUIRED)
	public DefaultErrorDto valueDuplicatedException(ValueEmptyException ex, WebRequest web) {
		DefaultErrorDto message = new DefaultErrorDto(ex.getMessage());
		return message;

	}
}
