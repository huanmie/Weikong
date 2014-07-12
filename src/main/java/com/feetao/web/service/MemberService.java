package com.feetao.web.service;

import com.feetao.web.vo.MemberVO;

public interface MemberService {

	/**
	 * 进入微网站的记录
	 * @param openId
	 * @param userId
	 */
	public void enterMember(String openId , Long userId);

	/**
	 * 更新会员信息
	 * @param openId
	 * @param userId
	 * @param name
	 * @param source
	 * @param score
	 */
	public void updateMember(Long userId , String openId , String name , Long score , String source);
	
	/**
	 * 获取会员信息
	 * @param userId
	 * @param openId
	 */
	public MemberVO getMember(Long userId, String openId);
}
