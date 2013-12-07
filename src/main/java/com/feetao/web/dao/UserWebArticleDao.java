package com.feetao.web.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.feetao.web.constants.StatusType;
import com.feetao.web.model.UserWebArticleDO;

public class UserWebArticleDao extends SqlMapClientDaoSupport {

	@SuppressWarnings("unchecked")
	public ArrayList<UserWebArticleDO> getList(Long userId , Long cursor , Byte direction , Integer size) {
		Map<String, Object> params = new HashMap<String , Object>();
		params.put("userId", userId);
		params.put("cursor", cursor);
		params.put("size", size);
		params.put("status", StatusType.PUBLISH);
		return (ArrayList<UserWebArticleDO>) this.getSqlMapClientTemplate().queryForList((direction!=null&&direction > 0) ? 
				"user_web_article.getForward":"user_web_article.getBack", params);
	}
	
	public UserWebArticleDO get(Long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("status", StatusType.PUBLISH);
		return (UserWebArticleDO) this.getSqlMapClientTemplate().queryForObject("user_web_article.getArticleById", params);
	}

}
