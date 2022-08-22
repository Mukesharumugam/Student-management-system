package com.sms.service;

import com.sms.exception.ErrorMessage;

public class StudentUpdateException extends Exception {
	private static final long serialVersionUID = 1L;
	public StudentUpdateException (String str) {
		ErrorMessage em = new ErrorMessage(0, null, str, null);
	}
}
