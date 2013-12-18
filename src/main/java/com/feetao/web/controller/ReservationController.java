package com.feetao.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 预订
 * @author feetao
 */
@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@ResponseBody
	@RequestMapping("/list")
	public Object listReservation(@RequestParam(value = "cursor", required = false , defaultValue="9223372036854775807") Long cursor , 
			@RequestParam(value = "direction", required = false , defaultValue="1") Byte direction , 
			@RequestParam(value = "size", required = false , defaultValue="10") Integer size) {
		return null;
	}

	@ResponseBody
	@RequestMapping("/add")
	public Object addReservation(@RequestParam("message") String message) {
		
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public Object removeReservation(@RequestParam("id") Long id) {
		
		return null;
	}

}
