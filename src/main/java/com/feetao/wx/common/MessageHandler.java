package com.feetao.wx.common;

import com.feetao.wx.vo.Article;
import com.feetao.wx.vo.MessageNewsSendVO;
import com.feetao.wx.vo.MessageReceiveVO;
import com.feetao.wx.vo.MessageSendVO;

public class MessageHandler {

	public static MessageSendVO hander(MessageReceiveVO receiver) {
		MessageNewsSendVO sender = new MessageNewsSendVO();
		sender.setFromUserName(receiver.getToUserName());
		sender.setToUserName(receiver.getFromUserName());
		sender.setCreateTime((int)(System.currentTimeMillis()/1000));
		sender.setMsgType("news");
		Article article = new Article();
		article.setTitle("吉普顿");
		article.setDescription("吉普顿，因你的选择而精彩，哈哈哈");
		article.setPicUrl("http://h.hiphotos.baidu.com/image/w%3D2048/sign=5e4b734239dbb6fd255be2263d1caa18/42a98226cffc1e1785134b884a90f603728de9df.jpg");
		article.setUrl("http://www.feetao.com");
		sender.addArticle(article);
		return sender;
	}
	
}
