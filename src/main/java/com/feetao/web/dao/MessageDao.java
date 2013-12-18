package com.feetao.web.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.feetao.web.constants.StatusType;
import com.feetao.web.model.MessageDO;

public class MessageDao extends SqlSessionDaoSupport {

	public void addChatMessage(MessageDO message) {
		message.setGmtCreate(System.currentTimeMillis());
		message.setGmtModified(System.currentTimeMillis());
		message.setStatus(StatusType.PUBLISH);
		this.getSqlSession().insert("userMessage.addChatMessage", message);
	}
	
	public void addBoardMessage(MessageDO message) {
		message.setGmtCreate(System.currentTimeMillis());
		message.setGmtModified(System.currentTimeMillis());
		message.setStatus(StatusType.PUBLISH);
		this.getSqlSession().insert("userMessage.addBoardMessage", message);
	}
}
