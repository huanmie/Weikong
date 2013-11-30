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
	protected Long gmt_create;
	
	/**
	 * 更新时间
	 */
	protected Long gmt_modified;

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Long getGmt_create() {
		return gmt_create;
	}

	public void setGmt_create(Long gmt_create) {
		this.gmt_create = gmt_create;
	}

	public Long getGmt_modified() {
		return gmt_modified;
	}

	public void setGmt_modified(Long gmt_modified) {
		this.gmt_modified = gmt_modified;
	}
	
}
