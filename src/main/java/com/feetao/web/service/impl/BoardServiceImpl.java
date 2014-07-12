package com.feetao.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.feetao.web.constants.StatusType;
import com.feetao.web.dao.BoardDao;
import com.feetao.web.model.BoardMsgDO;
import com.feetao.web.service.BoardService;
import com.feetao.web.utils.Convert;
import com.feetao.web.vo.BoardMsgVO;

public class BoardServiceImpl implements BoardService {

	@Resource
	private BoardDao boardDao;
	
	@Override
	public BoardMsgVO addMessage(Long userId, String openId, String content) {
		BoardMsgDO mdo = new BoardMsgDO();
		mdo.setUserId(userId);
		mdo.setOpenId(openId);
		mdo.setContent(content);
		mdo.setStatus(StatusType.ONLINE);
		boardDao.addBoardMsg(mdo);
		return Convert.convert(BoardMsgVO.class, mdo);
	}

	@Override
	public List<BoardMsgVO> getMessageList(Long userId , Long cursor , int size) {
		List<BoardMsgDO> list = boardDao.getBoardMsgList(userId, cursor, size);
		if(list != null && list.size() > 0) {
			ArrayList<BoardMsgVO> result = new ArrayList<BoardMsgVO>();
			for(int i = 0 ; i < list.size() ; i++)
				result.add(Convert.convert(BoardMsgVO.class , list.get(i)));
			return result;
		}
		return null;
	}

}
