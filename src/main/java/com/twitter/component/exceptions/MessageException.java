package com.twitter.component.exceptions;

public class MessageException {

	private String Message;

	public MessageException(String message) {
		super();
		Message = message;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
}
