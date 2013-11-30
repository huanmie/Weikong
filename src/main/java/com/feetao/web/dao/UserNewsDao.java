package com.feetao.web.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.feetao.web.constants.StatusType;
import com.feetao.web.model.UserNewsDO;

public class UserNewsDao extends SqlMapClientDaoSupport {

	@SuppressWarnings("unchecked")
	public ArrayList<UserNewsDO> getOnlineList(Long userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("status", StatusType.PUBLISH);
		return (ArrayList<UserNewsDO>) this.getSqlMapClientTemplate().queryForList("user_news.getOnlineList" , params);
	}

}
