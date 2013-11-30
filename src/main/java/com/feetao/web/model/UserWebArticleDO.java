package com.feetao.web.model;

import java.io.Serializable;

/**
 * 文章列表
 * @author feetao
 *
 */
public class UserWebArticleDO extends BaseDO implements Serializable {

	private static final long serialVersionUID = 1L;
	
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
	 * 原文链接
	 */
	private String url;
	
	/**
	 * 文章详情
	 */
	private String detail;

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

}
