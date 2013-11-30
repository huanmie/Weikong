package com.feetao.web.wx.vo;

public class Music {
	
	private String title;
	
	private String description;
	
	private String musicUrl;
	
	private String hqMusicUrl;
	
	private String thumbMediaId;

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

	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public String getHqMusicUrl() {
		return hqMusicUrl;
	}

	public void setHqMusicUrl(String hqMusicUrl) {
		this.hqMusicUrl = hqMusicUrl;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public void toXML(StringBuilder sb) {
		sb.append("<Music>");
		sb.append("<Title><![CDATA[").append(title).append("]]></Title>");
		sb.append("<Description><![CDATA[").append(description).append("]]></Description>");
		sb.append("<MusicUrl><![CDATA[").append(musicUrl).append("]]></MusicUrl>");
		sb.append("<HQMusicUrl><![CDATA[").append(hqMusicUrl).append("]]></HQMusicUrl>");
		sb.append("<ThumbMediaId><![CDATA[").append(thumbMediaId).append("]]></ThumbMediaId>");
		sb.append("</Music>");
	}
	
}
