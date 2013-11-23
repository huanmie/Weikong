package com.feetao.wx.vo;

public class MessageImageSendVO extends MessageSendVO {

	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	@Override
	public String toXML() {
		StringBuilder sb	= new StringBuilder("<xml>");
		sb.append("<ToUserName><![CDATA[").append(this.toUserName).append("]]></ToUserName>");
		sb.append("<FromUserName><![CDATA[").append(this.fromUserName).append("]]></FromUserName>");
		sb.append("<CreateTime>").append(this.createTime).append("</CreateTime>");
		sb.append("<MsgType><![CDATA[").append(this.msgType).append("]]></MsgType>");
		if(image != null)  image.toXML(sb);
		sb.append("</xml>");
		return sb.toString();
	}
}
