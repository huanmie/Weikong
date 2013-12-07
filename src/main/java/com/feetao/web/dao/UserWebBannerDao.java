package com.feetao.web.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.feetao.web.constants.StatusType;

public class UserWebBannerDao extends SqlMapClientDaoSupport {

	@SuppressWarnings("unchecked")
	public ArrayList<String> getOnlineList(Long userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("status", StatusType.PUBLISH);
		return (ArrayList<String>) this.getSqlMapClientTemplate().queryForList("user_web_banner.getOnlineList" , params);
	}

}
