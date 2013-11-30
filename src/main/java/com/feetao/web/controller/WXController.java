package com.feetao.web.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feetao.web.service.WXService;
import com.feetao.web.wx.vo.MessageReceiveVO;
import com.feetao.web.wx.vo.MessageSendVO;

@Controller
public class WXController {

	@Resource
	private WXService messageService;
	
	@ResponseBody
	@RequestMapping("mmc.Parse")
	public void parser(HttpServletRequest request , HttpServletResponse response) {
        try{
        	String signature 	= request.getParameter("signature");
        	String timestamp 	= request.getParameter("timestamp");
        	String nonce		= request.getParameter("nonce");
        	if(messageService.checkSign(signature, timestamp, nonce)) {
        		MessageReceiveVO receiver	= messageService.parse(request.getInputStream());
        		MessageSendVO sender		= messageService.hander(receiver);
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
