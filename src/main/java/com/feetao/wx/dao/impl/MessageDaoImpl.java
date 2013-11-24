package com.feetao.wx.dao.impl;

import java.util.ArrayList;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.feetao.wx.dao.MessageDao;
import com.feetao.wx.model.ArticleDO;

public class MessageDaoImpl extends SqlMapClientDaoSupport implements MessageDao {

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<ArticleDO> getNewsItem() {
		return (ArrayList<ArticleDO>) this.getSqlMapClientTemplate().queryForList("message.getList");
	}

}
