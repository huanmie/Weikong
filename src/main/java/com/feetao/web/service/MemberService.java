package com.feetao.web.service;

public interface MemberService {

	/**
	 * 进入微网站的记录
	 * @param openId
	 * @param userId
	 */
	public void enterMember(String openId , Long userId);
	
}
