package com.feetao.web.service.impl;

import java.util.Date;

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
			member.setLastEnter(new Date());
			memberDao.addMember(member);
		} else {
			member.setLastEnter(new Date());
			memberDao.updateMember(member);
		}
	}
	

}
