package com.feetao.wx.vo;

public class Video {
	
	private String mediaId;
	
	private String thumbMediaId;

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
	
	public void toXML(StringBuilder sb) {
		sb.append("<Video>");
		sb.append("<MediaId><![CDATA[").append(mediaId).append("]]></MediaId>");
		sb.append("<ThumbMediaId><![CDATA[").append(mediaId).append("]]></ThumbMediaId>");
		sb.append("</Video>");
	}

}
