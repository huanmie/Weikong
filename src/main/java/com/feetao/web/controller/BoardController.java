package com.feetao.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 留言板
 * @author feetao
 */
@Controller
@RequestMapping("/board")
public class BoardController {

	@ResponseBody
	@RequestMapping("/list")
	public Object listMessage(@RequestParam(value = "cursor", required = false , defaultValue="9223372036854775807") Long cursor , 
			@RequestParam(value = "direction", required = false , defaultValue="1") Byte direction , 
			@RequestParam(value = "size", required = false , defaultValue="10") Integer size) {
		return null;
	}
	
	
	public Object addMessage(@RequestParam("message") String message) {
		
		return null;
	}
	
	public Object removeMessage(@RequestParam("id") String id) {
		
		return null;
	}

}
