package com.foodbox.restbackend.exception;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1353560343025914073L;

	public UserNotFoundException(String message) {
        super(message);
    }
}
