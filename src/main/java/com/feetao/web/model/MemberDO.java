package com.feetao.web.model;

import java.io.Serializable;

public class MemberDO extends BaseDO implements Serializable {

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
	 * 会员号
	 */
	private String memberCode;
	
	/**
	 * 积分
	 */
	private Long score;

	/**
	 * 上次来的时间
	 */
	private Long lastEnter;

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

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Long getLastEnter() {
		return lastEnter;
	}

	public void setLastEnter(Long lastEnter) {
		this.lastEnter = lastEnter;
	}
	
}
