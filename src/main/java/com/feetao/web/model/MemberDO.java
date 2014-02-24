package com.feetao.web.model;

import java.io.Serializable;
import java.util.Date;

public class MemberDO implements Serializable {

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
	 * 会员ID
	 */
	private String openId;
	
	/**
	 * 会员名字
	 */
	private String name;
	
	/**
	 * 积分
	 */
	private Long score;
	
	/**
	 * 来源
	 */
	private String source;

	/**
	 * 上次来的时间
	 */
	private Date lastEnter;
	
	/**
	 * 状态
	 */
	private Byte status;

	/**
	 * create time
	 */
	private Date gmtCreate;

	/**
	 * modified time
	 */
	private Date gmtModified;
	
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

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getLastEnter() {
		return lastEnter;
	}

	public void setLastEnter(Date lastEnter) {
		this.lastEnter = lastEnter;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
}
