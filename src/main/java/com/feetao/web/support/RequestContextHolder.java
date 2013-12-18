package com.feetao.web.support;

public class RequestContextHolder {

	private ThreadLocal<RequestData> threadData = new ThreadLocal<RequestData>(); 
	
	public void set(RequestData data) {
		threadData.set(data);
	}
	
	public RequestData getRequestData() {
		return threadData.get();  
	}
	
	public void remove() {
		threadData.remove();
	}
}
