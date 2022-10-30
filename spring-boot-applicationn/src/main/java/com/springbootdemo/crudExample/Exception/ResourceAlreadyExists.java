package com.springbootdemo.crudExample.Exception;

public class ResourceAlreadyExists extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceAlreadyExists(String message) {
        super(message);
    }
}