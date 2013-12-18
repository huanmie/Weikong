package com.feetao.web.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feetao.web.service.ChatService;
import com.feetao.web.service.MessageService;
import com.feetao.web.wx.vo.MessageReceiveVO;
import com.feetao.web.wx.vo.MessageSendVO;

/**
 * 微信聊天
 * @author feetao
 */
@Controller
@RequestMapping("/api")
public class ChatController {

	@Resource
	private ChatService chatService;

	@Resource
	private MessageService messageService;
	
	@ResponseBody
	@RequestMapping("/{userId}")
	public void parser(@PathVariable("userId") Long userId, HttpServletRequest request , HttpServletResponse response) {
        try{
        	String signature 	= request.getParameter("signature");
        	String timestamp 	= request.getParameter("timestamp");
        	String nonce		= request.getParameter("nonce");
        	if(chatService.checkSign(signature, timestamp, nonce)) {
        		//分析用户信息
        		MessageReceiveVO receiver	= chatService.parse(request.getInputStream());
        		//同步信息到数据库
        		messageService.addChatMessage(userId, receiver.getFromUserName(), receiver.toString());
        		//处理用户请求
        		MessageSendVO sender		= chatService.hander(userId , receiver);
        		if(sender != null) {
        			PrintWriter out				= response.getWriter();
        			System.out.println(sender.toXML());
        			out.print(sender.toXML());
        			out.close();
        		}
        	}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}