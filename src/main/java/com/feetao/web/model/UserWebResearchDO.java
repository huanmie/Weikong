package com.feetao.web.model;

import java.io.Serializable;

/**
 * 企业调研
 * @author feetao
 */
public class UserWebResearchDO extends BaseDO implements Serializable {

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
	 * 调研说明
	 */
	private String title;
	
	/**
	 * 调研条件
	 */
	private String condition;
	
	/**
	 * 调研结果
	 */
	private String result;

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

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
