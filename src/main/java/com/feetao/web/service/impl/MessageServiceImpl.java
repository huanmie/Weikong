package com.feetao.web.service.impl;

import javax.annotation.Resource;

import com.feetao.web.dao.MessageDao;
import com.feetao.web.model.MessageDO;
import com.feetao.web.service.MessageService;

public class MessageServiceImpl implements MessageService {

	@Resource
	private MessageDao messageDao;
	
	
	@Override
	public void addChatMessage(Long userId , String openId , String content) {
		MessageDO message = new MessageDO();
		message.setUserId(userId);
		message.setOpenId(openId);
		message.setContent(content);
		messageDao.addChatMessage(message);
	}

	@Override
	public void addBoardMessage(Long userId , String openId , String content) {
		MessageDO message = new MessageDO();
		message.setUserId(userId);
		message.setOpenId(openId);
		message.setContent(content);
		messageDao.addBoardMessage(message);
	}

}
