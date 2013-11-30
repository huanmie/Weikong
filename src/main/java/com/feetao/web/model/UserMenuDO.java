package com.feetao.web.model;

import java.io.Serializable;


/**
 * 微信自定义菜单
 * @author feetao
 */
public class UserMenuDO extends BaseDO implements Serializable {

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
	 * button类型
	 */
	private String buttonType;
	
	/**
	 * button名称
	 */
	private String buttonName;
	
	/**
	 * button的Key
	 */
	private String buttonKey;
	
	/**
	 * button层次
	 */
	private String buttonLevel;
	
	/**
	 * 父节点ID
	 */
	private Long parentId;

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

	public String getButtonType() {
		return buttonType;
	}

	public void setButtonType(String buttonType) {
		this.buttonType = buttonType;
	}

	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	public String getButtonKey() {
		return buttonKey;
	}

	public void setButtonKey(String buttonKey) {
		this.buttonKey = buttonKey;
	}

	public String getButtonLevel() {
		return buttonLevel;
	}

	public void setButtonLevel(String buttonLevel) {
		this.buttonLevel = buttonLevel;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
}
