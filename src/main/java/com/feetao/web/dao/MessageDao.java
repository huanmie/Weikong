package com.feetao.web.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.feetao.web.constants.StatusType;
import com.feetao.web.model.MessageDO;

public class MessageDao extends SqlSessionDaoSupport {

	public void addMessage(MessageDO message) {
		message.setStatus(StatusType.ONLINE);
		this.getSqlSession().insert("message.addMessage", message);
	}
	
}
