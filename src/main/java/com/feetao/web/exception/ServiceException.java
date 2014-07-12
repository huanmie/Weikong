package com.feetao.web.exception;

import com.feetao.web.constants.ConstantsError;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -6050724944253131591L;
	
	private String errorCode;
	
	public ServiceException(ConstantsError error) {
		super(error.getErrorMsg());
		this.errorCode = error.getErrorCode();
	}
	
	public ServiceException(String errorCode , String errorMsg) {
		super(errorMsg);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
}
