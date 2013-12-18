package com.feetao.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 会员
 * @author feetao
 */
@Controller
@RequestMapping("/member")
public class MemberController {

	@ResponseBody
	@RequestMapping("/update")
	public Object updateMember(@RequestParam("id") Long id) {
		
		return null;
	}

}
