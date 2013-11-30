package com.feetao.web.model;

import java.io.Serializable;

/**
 * 企业简介说明
 * @author feetao
 */
public class UserWebSummaryDO extends BaseDO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private Long userId;
	
	/**
	 * 文章内容
	 */
	private String summary;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	
}
