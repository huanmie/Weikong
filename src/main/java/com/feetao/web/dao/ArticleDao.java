package com.feetao.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.feetao.web.constants.StatusType;
import com.feetao.web.model.ArticleDO;

public class ArticleDao extends SqlSessionDaoSupport  {

	public List<ArticleDO> getNewsList(Long userId , String item) {
		Map<String, Object> params = new HashMap<String , Object>();
		params.put("userId", userId);
		params.put("item", item);
		params.put("status", StatusType.ONLINE);
		return this.getSqlSession().selectList("article.getNewsList", params);
	}
	
	public List<ArticleDO> getBannerList(Long userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("status", StatusType.ONLINE);
		return this.getSqlSession().selectList("article.getBannerList" , params);
	}
	
	public ArticleDO get(Long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("status", StatusType.ONLINE);
		return this.getSqlSession().selectOne("article.getArticleById", params);
	}

}
