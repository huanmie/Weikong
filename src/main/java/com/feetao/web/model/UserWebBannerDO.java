package com.feetao.web.model;

import java.io.Serializable;

/**
 * 首页banner
 * @author feetao
 */
public class UserWebBannerDO extends BaseDO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Long userId;
	
	private String picUrl;

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

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
}
