package com.feetao.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feetao.web.constants.Result;
import com.feetao.web.service.BoardService;
import com.feetao.web.service.MemberService;
import com.feetao.web.support.RequestContextHolder;
import com.feetao.web.support.RequestData;
import com.feetao.web.vo.BoardMsgVO;

/**
 * 留言板
 * <p>Title: AddressController.java</p>
 * <p>Description: </p>
 * @author yida.zyd
 * @date 2014-4-8
 * @version 1.0
 */
@Controller
@RequestMapping("/board")
public class BoardController {

	@Resource
	private BoardService boardService;
	
	@Resource
	private MemberService memberService;
	
	@Resource
	private RequestContextHolder requestContextHolder;

	@ResponseBody
	@RequestMapping("/add")
	public Object addAddress(@RequestParam("content") String content) {
		Result<BoardMsgVO> result = new Result<BoardMsgVO>();
		RequestData data = requestContextHolder.getRequestData();
		BoardMsgVO mvo = boardService.addMessage(data.getUserId(), data.getOpenId(), content);
		result.setResult(mvo);
		return result;
	}

}
