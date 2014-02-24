package com.feetao.web.exception;

public class ParamInvalidException extends RuntimeException {

	private static final long serialVersionUID = 1L;
    
	public ParamInvalidException() {
		super();
    }

    public ParamInvalidException(String message) {
    	super(message);
    }
}
