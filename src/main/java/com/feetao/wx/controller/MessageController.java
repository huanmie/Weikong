package com.feetao.wx.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feetao.wx.service.MessageService;
import com.feetao.wx.vo.MessageReceiveVO;
import com.feetao.wx.vo.MessageSendVO;

@Controller
public class MessageController {

	@Resource
	private MessageService messageService;
	
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
