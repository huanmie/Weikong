package com.feetao.web.dao;

import java.util.ArrayList;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.feetao.web.model.UserNewsDO;

public class UserNewsDao extends SqlMapClientDaoSupport {

	@SuppressWarnings("unchecked")
	public ArrayList<UserNewsDO> getNewsList() {
		return (ArrayList<UserNewsDO>) this.getSqlMapClientTemplate().queryForList("message.getList");
	}

}
