package com.feetao.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feetao.web.constants.Result;
import com.feetao.web.service.MemberService;
import com.feetao.web.support.RequestContextHolder;
import com.feetao.web.support.RequestData;

/**
 * 会员功能
 * <p>Title: MemberController.java</p>
 * <p>Description: </p>
 * @author yida.zyd
 * @date 2014-4-8
 * @version 1.0
 */
@Controller
@RequestMapping("/member")
public class MemberController {

	@Resource
	private MemberService memberService;
	
	@Resource
	private RequestContextHolder requestContextHolder;
	
	@ResponseBody
	@RequestMapping("/update")
	public Object updateAddress() {
		Result<Object> result = new Result<Object>();
		RequestData data = requestContextHolder.getRequestData();
		memberService.updateMember(data.getUserId() , data.getOpenId() , null,  null , null);
		return result;
	}

}
