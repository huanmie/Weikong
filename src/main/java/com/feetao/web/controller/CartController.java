package com.feetao.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 购物车
 * @author feetao
 */
@Controller
@RequestMapping("/cart")
public class CartController {

	@ResponseBody
	@RequestMapping("/list")
	public Object listCollection(@RequestParam(value = "cursor", required = false , defaultValue="9223372036854775807") Long cursor , 
			@RequestParam(value = "direction", required = false , defaultValue="1") Byte direction , 
			@RequestParam(value = "size", required = false , defaultValue="10") Integer size) {
		return null;
	}

	@ResponseBody
	@RequestMapping("/add")
	public Object addCollection(@RequestParam("id") Long id) {
		
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public Object removeCollection(@RequestParam("id") Long id) {
		
		return null;
	}
	
	

}
