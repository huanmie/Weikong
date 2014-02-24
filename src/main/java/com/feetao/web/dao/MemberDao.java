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
		return this.getSqlSession().selectOne("member.getMemberByOpenIdAndUserId", params);
	}

	public void addMember(MemberDO member) {
		member.setStatus(StatusType.ONLINE);
		this.getSqlSession().insert("member.addMember" , member);
	}
	
	public void updateMember(MemberDO member) {
		this.getSqlSession().update("member.updateMember", member);
	}
	
}
