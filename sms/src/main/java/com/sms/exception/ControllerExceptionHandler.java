package com.sms.exception;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.sms.service.StudentUpdateException;

@RestControllerAdvice
public class ControllerExceptionHandler {

	public ResponseEntity<ErrorMessage> CustomException(StudentUpdateException ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(0), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<ErrorMessage>(message,HttpStatus.NOT_FOUND);

	}

}
