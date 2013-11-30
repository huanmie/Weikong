package com.feetao.web.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feetao.web.service.ApiService;
import com.feetao.web.wx.vo.MessageReceiveVO;
import com.feetao.web.wx.vo.MessageSendVO;

@Controller
@RequestMapping("/api")
public class ApiController {

	@Resource
	private ApiService apiService;
	
	@ResponseBody
	@RequestMapping("/{userId}")
	public void parser(@PathVariable("userId") Long userId, HttpServletRequest request , HttpServletResponse response) {
        try{
        	String signature 	= request.getParameter("signature");
        	String timestamp 	= request.getParameter("timestamp");
        	String nonce		= request.getParameter("nonce");
        	if(apiService.checkSign(signature, timestamp, nonce)) {
        		MessageReceiveVO receiver	= apiService.parse(request.getInputStream());
        		MessageSendVO sender		= apiService.hander(userId , receiver);
        		if(sender != null) {
        			PrintWriter out				= response.getWriter();
        			out.print(sender.toXML());
        			out.close();
        		}
        	}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}