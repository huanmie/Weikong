package com.feetao.web.vo;

public class WebArticle {

	/**
	 * 主键ID
	 */
	private Long id;
	
	/**
	 * 用户ID
	 */
	private Long userId;
	
	/**
	 * 文章标题
	 */
	private String title;
	
	/**
	 * 文章描述
	 */
	private String description;
	
	/**
	 * 文章图片链接
	 */
	private String picUrl;
	
	/**
	 * 插件类型
	 */
	private String plugin;
	
	/**
	 * 原文链接
	 */
	private String url;
	
	/**
	 * 文章详情
	 */
	private String detail;
	
	/**
	 * 点击跳转地址
	 */
	private String link;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPlugin() {
		return plugin;
	}

	public void setPlugin(String plugin) {
		this.plugin = plugin;
	}


}
