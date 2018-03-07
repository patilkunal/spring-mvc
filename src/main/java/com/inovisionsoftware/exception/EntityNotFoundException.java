package com.inovisionsoftware.exception;


public class EntityNotFoundException extends Exception {

	
	private static final long serialVersionUID = 7687598074844654113L;

	public EntityNotFoundException(String message) {
		super(message);
	}
	
	public EntityNotFoundException(String message, Throwable t) {
		super(message, t);
	}
}
