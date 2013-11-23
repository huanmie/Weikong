package com.feetao.wx.vo;


public class MessageTextSendVO extends MessageSendVO {

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toXML() {
		StringBuilder sb	= new StringBuilder("<xml>");
		sb.append("<ToUserName><![CDATA[").append(this.toUserName).append("]]></ToUserName>");
		sb.append("<FromUserName><![CDATA[").append(this.fromUserName).append("]]></FromUserName>");
		sb.append("<CreateTime>").append(this.createTime).append("</CreateTime>");
		sb.append("<MsgType><![CDATA[").append(this.msgType).append("]]></MsgType>");
		sb.append("<Content><![CDATA[").append(this.content).append("]]></Content>");
		sb.append("</xml>");
		return sb.toString();
	}
	
}
