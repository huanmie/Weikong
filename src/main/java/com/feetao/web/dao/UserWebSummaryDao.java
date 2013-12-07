package com.feetao.web.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.feetao.web.constants.StatusType;

public class UserWebSummaryDao extends SqlMapClientDaoSupport {

	public String getOnline(Long userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("status", StatusType.PUBLISH);
		return  (String) this.getSqlMapClientTemplate().queryForObject("user_web_summary.getOnline" , params);
	}

}
