package com.feetao.web.constants;

public enum ConstantsError {

	SystemError("100" , "系统碰到点问题，请耐心等待"),
	InvalidArguemnt("101" , "参数不合法");
	
	private String errorCode;
	
	private String errorMsg;
	
	private ConstantsError(String errorCode , String errorMsg) {
		this.errorCode  = errorCode;
		this.errorMsg	= errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
