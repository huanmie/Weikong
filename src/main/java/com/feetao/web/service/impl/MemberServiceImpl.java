package com.feetao.web.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import com.feetao.web.dao.MemberDao;
import com.feetao.web.model.MemberDO;
import com.feetao.web.service.MemberService;
import com.feetao.web.utils.Convert;
import com.feetao.web.vo.MemberVO;

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

	@Override
	public void updateMember(Long userId, String openId, String name, Long score, String source) {
		MemberDO mdo = new MemberDO();
		mdo.setUserId(userId);
		mdo.setOpenId(openId);
		mdo.setName(name);
		mdo.setScore(score);
		mdo.setSource(source);
		memberDao.updateMember(mdo);
	}

	@Override
	public MemberVO getMember(Long userId, String openId) {
		MemberDO mdo = memberDao.getMemberByOpenIdAndUserId(openId, userId);
		return Convert.convert(MemberVO.class, mdo);
	}

}
