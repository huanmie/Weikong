package com.feetao.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.feetao.web.constants.StatusType;
import com.feetao.web.model.BoardMsgDO;

public class BoardDao extends SqlSessionDaoSupport {

	public List<BoardMsgDO> getBoardMsgList(Long userId , Long cursor , int size) {
		Map<String, Object> params = new HashMap<String , Object>();
		params.put("userId", userId);
		params.put("cursor", cursor);
		params.put("size", size);
		params.put("status", StatusType.ONLINE);
		return this.getSqlSession().selectList("board.getMessageList", params);
	}

	public void addBoardMsg(BoardMsgDO mdo) {
		mdo.setStatus(StatusType.ONLINE);
		this.getSqlSession().insert("board.addMessage", mdo);
	}
	
}
