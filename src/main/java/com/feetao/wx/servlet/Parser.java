package com.feetao.wx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feetao.wx.common.MessageHandler;
import com.feetao.wx.common.MessageReceiveParser;
import com.feetao.wx.vo.MessageReceiveVO;
import com.feetao.wx.vo.MessageSendVO;

public class Parser extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
        response.setCharacterEncoding("UTF-8");
        try{
        	String signature 	= request.getParameter("signature");
        	String timestamp 	= request.getParameter("timestamp");
        	String nonce		= request.getParameter("nonce");
        	try{
        		boolean boo = MessageReceiveParser.checkSignature(signature, timestamp, nonce);
        		System.out.println("------------------helloworld--------------:" + boo);
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
	        MessageReceiveVO receiver 	= MessageReceiveParser.parse(request.getInputStream());
	        MessageSendVO sender 		= MessageHandler.hander(receiver);
	        PrintWriter out				= response.getWriter();
	        out.print(sender.toXML());
	        out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
