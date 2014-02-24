package com.feetao.web.service;

public interface MessageService {

	/**
	 * 来自微信的内容
	 * @param userId
	 * @param openId
	 * @param content
	 */
	public void addMessage(Long userId , String openId , String content);
	
}
