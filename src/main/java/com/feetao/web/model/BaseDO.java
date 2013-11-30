package com.feetao.web.model;

import java.io.Serializable;

public abstract class BaseDO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 状态
	 */
	protected Byte status;
	
	/**
	 * 创建时间
	 */
	protected Long gmtCreate;
	
	/**
	 * 更新时间
	 */
	protected Long gmtModified;

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Long getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Long gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Long getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Long gmtModified) {
		this.gmtModified = gmtModified;
	}

}
