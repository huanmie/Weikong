package com.feetao.wx.vo;

import org.dom4j.Element;

public abstract class MessageReceiveVO extends MessageVO {

	public void setProperties(Element root) {
		this.toUserName 	= root.element("ToUserName").getTextTrim();  
		this.fromUserName 	= root.element("FromUserName").getTextTrim();
		this.createTime		= Integer.parseInt(root.element("CreateTime").getTextTrim());
		this.msgType		= root.element("MsgType").getTextTrim();
	}
	
}
