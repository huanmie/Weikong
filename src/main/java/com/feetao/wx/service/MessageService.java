package com.feetao.wx.service;

import java.io.InputStream;

import org.dom4j.DocumentException;

import com.feetao.wx.vo.MessageReceiveVO;
import com.feetao.wx.vo.MessageSendVO;

public interface MessageService {

	/**
	 * 解析消息内容
	 * @param in
	 * @return
	 * @throws DocumentException
	 */
	public MessageReceiveVO parse(InputStream in) throws DocumentException;

	/**
	 * 处理消息，并且返回内容
	 * @param receiver
	 * @return
	 */
	public MessageSendVO hander(MessageReceiveVO receiver);
	
	/**
	 * 校验消息的合法性
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public boolean checkSign(String signature , String timestamp , String nonce);
	
}
