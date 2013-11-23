package com.feetao.wx.vo;

public class Article {
	
	private String title;
	
	private String description;
	
	private String picUrl;
	
	private String url;

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

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void toXML(StringBuilder sb) {
		sb.append("<item>");
		sb.append("<Title><![CDATA[").append(title).append("]]></Title>");
		sb.append("<Description><![CDATA[").append(description).append("]]></Description>");
		sb.append("<PicUrl><![CDATA[").append(picUrl).append("]]></PicUrl>");
		sb.append("<Url><![CDATA[").append(url).append("]]></Url>");
		sb.append("</item>");
	}

	
}
