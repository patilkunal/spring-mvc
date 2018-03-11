package com.inovisionsoftware.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.FORBIDDEN, reason="User with role 'USER' are allowed for a cart")
public class CartNotAllowedException extends Exception {

	private static final long serialVersionUID = 2231468077774463583L;

	public CartNotAllowedException(String msg) {
		super(msg);
	}
}
