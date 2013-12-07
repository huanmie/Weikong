package com.feetao.web.vo;


public class CommonArgs {

	public static String UID		= "userId";
	public static String USERCHATID	= "userChatId";
	public static String PUBCHATID	= "pubChatId";

	/**
	 * 用户id
	 */
	private Long userId;
	
	/**
	 * 关注者id
	 */
	private String userChatId;
	
	/**
	 * 公众账号微信id
	 */
	private String pubChatId;

	public CommonArgs(){
	}
	
	public CommonArgs(Long userId, String userChatId, String pubChatId) {
		super();
		this.userId = userId;
		this.userChatId = userChatId;
		this.pubChatId = pubChatId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserChatId() {
		return userChatId;
	}

	public void setUserChatId(String userChatId) {
		this.userChatId = userChatId;
	}

	public String getPubChatId() {
		return pubChatId;
	}

	public void setPubChatId(String pubChatId) {
		this.pubChatId = pubChatId;
	}

}
