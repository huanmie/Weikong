package com.feetao.wx.vo;

public class MessageVideoSendVO extends MessageSendVO {

	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
	
	@Override
	public String toXML() {
		StringBuilder sb	= new StringBuilder("<xml>");
		sb.append("<ToUserName><![CDATA[").append(this.toUserName).append("]]></ToUserName>");
		sb.append("<FromUserName><![CDATA[").append(this.fromUserName).append("]]></FromUserName>");
		sb.append("<CreateTime>").append(this.createTime).append("</CreateTime>");
		sb.append("<MsgType><![CDATA[").append(this.msgType).append("]]></MsgType>");
		if(video != null)  video.toXML(sb);
		sb.append("</xml>");
		return sb.toString();
	}

}
