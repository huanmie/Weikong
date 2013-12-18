package com.feetao.web.service.impl;

import javax.annotation.Resource;

import com.feetao.web.dao.MemberDao;
import com.feetao.web.model.MemberDO;
import com.feetao.web.service.MemberService;

public class MemberServiceImpl implements MemberService {

	@Resource
	private MemberDao memberDao;
	
	@Override
	public void enterMember(String openId , Long userId) {
		MemberDO member  = memberDao.getMemberByOpenIdAndUserId(openId, userId);
		if(member == null) {
			member = new MemberDO();
			member.setUserId(userId);
			member.setOpenId(openId);
			member.setLastEnter(System.currentTimeMillis());
			memberDao.insertMember(member);
		} else {
			member.setLastEnter(System.currentTimeMillis());
			memberDao.updateMember(member);
		}
	}
	

}
