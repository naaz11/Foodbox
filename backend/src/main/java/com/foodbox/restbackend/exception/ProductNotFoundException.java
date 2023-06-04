package com.foodbox.restbackend.exception;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3590180148432846997L;

	public ProductNotFoundException(String message) {
        super(message);
    }
}
