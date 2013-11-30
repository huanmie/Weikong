package com.feetao.web.wx.vo;

import org.dom4j.Element;

public class MessageImageReceiveVO extends MessageReceiveVO {
	
	private String picUrl;
	
	private String mediaId;
	
	private String msgId;

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
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
		this.picUrl	 = root.element("PicUrl").getTextTrim();
		this.mediaId = root.element("MediaId").getTextTrim();
		this.msgId	 = root.element("MsgId").getTextTrim();
	}

}
