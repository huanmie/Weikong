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
import com.feetao.web.vo.AddressVO;

/**
 * 收货地址
 * <p>Title: AddressController.java</p>
 * <p>Description: </p>
 * @author yida.zyd
 * @date 2014-4-8
 * @version 1.0
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
		Result<AddressVO> result = new Result<AddressVO>();
		RequestData data = requestContextHolder.getRequestData();
		AddressVO avo = addressService.addAddress(data.getUserId() , data.getOpenId() , name , mobile , address);
		result.setResult(avo);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public Object updateAddress(@RequestParam("id") Long id , @RequestParam("name") String name , @RequestParam("mobile") String mobile , @RequestParam("address") String address) {
		Result<Object> result = new Result<Object>();
		RequestData data = requestContextHolder.getRequestData();
		addressService.updateAddress(data.getUserId() , data.getOpenId() , id,  name , mobile , address);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/set")
	public Object setAddress(@RequestParam("id") Long id) {
		Result<Object> result = new Result<Object>();
		RequestData data = requestContextHolder.getRequestData();
		addressService.setAddress(data.getUserId() , data.getOpenId() , id);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public Object removeAddress(@RequestParam("id") Long id) {
		Result<Object> result = new Result<Object>(); 
		RequestData data = requestContextHolder.getRequestData();
		addressService.removeAddress(data.getUserId() , data.getOpenId() , id);
		return result;
	}

}
