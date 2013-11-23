package com.feetao.wx.vo;

import org.dom4j.Element;

public class MessageVideoReceiveVO extends MessageReceiveVO {

	private String mediaId;
	
	private String thumbMediaId;
	
	private String msgId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
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
		this.mediaId	 	= root.element("MediaId").getTextTrim();
		this.thumbMediaId 	= root.element("ThumbMediaId").getTextTrim();
		this.msgId	 		= root.element("MsgId").getTextTrim();
	}

}
