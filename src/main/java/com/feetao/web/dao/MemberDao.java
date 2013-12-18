package com.feetao.web.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.feetao.web.constants.StatusType;
import com.feetao.web.model.MemberDO;

public class MemberDao extends SqlSessionDaoSupport {

	public MemberDO getMemberByOpenIdAndUserId(String openId , Long userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("openId", openId);
		params.put("userId", userId);
		return this.getSqlSession().selectOne("userMember.getMemberByOpenIdAndUserId", params);
	}
	
	public void updateMember(MemberDO member) {
		this.getSqlSession().update("userMember.updateMember", member);
	}
	
	public void insertMember(MemberDO member) {
		member.setGmtCreate(System.currentTimeMillis());
		member.setGmtModified(System.currentTimeMillis());
		member.setStatus(StatusType.PUBLISH);
		this.getSqlSession().insert("userMember.addMember" , member);
	}
}
