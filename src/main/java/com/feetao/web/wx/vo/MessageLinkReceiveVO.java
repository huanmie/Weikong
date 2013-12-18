package com.feetao.web.wx.vo;

import org.dom4j.Element;

public class MessageLinkReceiveVO extends MessageReceiveVO {

	private String title;
	
	private String description;
	
	private String url;
	
	private String msgId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
		this.title	 		= root.element("Title").getTextTrim();
		this.description 	= root.element("Description").getTextTrim();
		this.url			= root.element("Url").getTextTrim();
		this.msgId	 		= root.element("MsgId").getTextTrim();
	}

	@Override
	public String toString() {
		return "MessageLinkReceiveVO [title=" + title + ", description="
				+ description + ", url=" + url + ", msgId=" + msgId + "]";
	}
	
}
