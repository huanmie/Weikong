package com.feetao.web.wx.vo;

import org.dom4j.Element;


public class MessageTextReceiveVO extends MessageReceiveVO {

	private String content;

	private String msgId;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	@Override
	public void setProperties(Element root) {
		super.setProperties(root);
		this.content = root.element("Content").getTextTrim();
		this.msgId	 = root.element("MsgId").getTextTrim();
	}
	
}
