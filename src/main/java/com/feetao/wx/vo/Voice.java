package com.feetao.wx.vo;

public class Voice {

	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	public void toXML(StringBuilder sb) {
		sb.append("<Voice>");
		sb.append("<MediaId><![CDATA[").append(mediaId).append("]]></MediaId>");
		sb.append("</Voice>");
	}
}
