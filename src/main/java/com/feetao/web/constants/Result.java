package com.feetao.web.constants;

/**
 * JSON返回结果
 * <p>Title: Result.java</p>
 * <p>Description: </p>
 * @author yida.zyd
 * @date 2014-4-8
 * @version 1.0
 */
public class Result<T> {

	private boolean success = true;
	
	private String errorCode;
	
	private String errorMsg;
	
	private T result;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
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

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
	
}
