package com.feetao.web.support;

public class RequestData {

	/**
	 * 用户id
	 */
	private Long userId;
	
	/**
	 * 关注者id
	 */
	private String openId;
	
	/**
	 * 公众账号微信id
	 */
	private String pubId;
	

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

	public String getPubId() {
		return pubId;
	}

	public void setPubId(String pubId) {
		this.pubId = pubId;
	}

	@Override
	public String toString() {
		return "RequestData [userId=" + userId + ", openId=" + openId
				+ ", pubId=" + pubId + "]";
	}
	
}
