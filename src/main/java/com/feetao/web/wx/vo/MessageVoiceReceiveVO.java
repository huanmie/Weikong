package com.feetao.web.wx.vo;

import org.dom4j.Element;

public class MessageVoiceReceiveVO extends MessageReceiveVO {

	private String mediaId;
	
	private String format;
	
	private String msgId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
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
		this.mediaId	= root.element("MediaId").getTextTrim();
		this.format 	= root.element("Format").getTextTrim();
		this.msgId	 	= root.element("MsgId").getTextTrim();
	}

	@Override
	public String toString() {
		return "MessageVoiceReceiveVO [mediaId=" + mediaId + ", format="
				+ format + ", msgId=" + msgId + "]";
	}

}
