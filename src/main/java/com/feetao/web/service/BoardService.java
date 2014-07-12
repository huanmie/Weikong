package com.feetao.web.service;

import java.util.List;

import com.feetao.web.vo.BoardMsgVO;

public interface BoardService {

	public BoardMsgVO addMessage(Long userId, String openId , String content);
	
	public List<BoardMsgVO> getMessageList(Long userId , Long cursor , int size);
}
