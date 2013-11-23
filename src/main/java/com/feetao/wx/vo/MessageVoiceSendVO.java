package com.feetao.wx.vo;

public class MessageVoiceSendVO extends MessageSendVO {

	private Voice voice;

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	@Override
	public String toXML() {
		StringBuilder sb	= new StringBuilder("<xml>");
		sb.append("<ToUserName><![CDATA[").append(this.toUserName).append("]]></ToUserName>");
		sb.append("<FromUserName><![CDATA[").append(this.fromUserName).append("]]></FromUserName>");
		sb.append("<CreateTime>").append(this.createTime).append("</CreateTime>");
		sb.append("<MsgType><![CDATA[").append(this.msgType).append("]]></MsgType>");
		if(voice != null)  voice.toXML(sb);
		sb.append("</xml>");
		return sb.toString();
	}
	
}
