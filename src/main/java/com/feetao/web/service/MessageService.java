package com.feetao.web.service;

public interface MessageService {

	/**
	 * 来自微信的内容
	 * @param userId
	 * @param openId
	 * @param content
	 */
	public void addChatMessage(Long userId , String openId , String content);
	
	/**
	 * 来自留言板的内容
	 * @param userId
	 * @param openId
	 * @param content
	 */
	public void addBoardMessage(Long userId , String openId , String content);
}
