package com.feetao.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feetao.web.constants.Result;
import com.feetao.web.service.AddressService;
import com.feetao.web.support.RequestContextHolder;
import com.feetao.web.support.RequestData;

/**
 * 收货地址
 * @author feetao
 */
@Controller
@RequestMapping("/address")
public class AddressController {

	@Resource
	private AddressService addressService;
	
	@Resource
	private RequestContextHolder requestContextHolder;

	@ResponseBody
	@RequestMapping("/add")
	public Object addAddress(@RequestParam("name") String name , @RequestParam("mobile") String mobile , @RequestParam("address") String address) {
		RequestData data = requestContextHolder.getRequestData();
		return addressService.addAddress(data.getUserId() , data.getOpenId() , name , mobile , address);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public Object updateAddress(@RequestParam("id") Long id , @RequestParam("name") String name , @RequestParam("mobile") String mobile , @RequestParam("address") String address) {
		RequestData data = requestContextHolder.getRequestData();
		addressService.updateAddress(data.getUserId() , data.getOpenId() , id,  name , mobile , address);
		return new Result();
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public Object removeAddress(@RequestParam("id") Long id) {
		RequestData data = requestContextHolder.getRequestData();
		addressService.removeAddress(data.getUserId() , data.getOpenId() , id);
		return new Result();
	}
	

}
