package com.feetao.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.feetao.web.constants.StatusType;
import com.feetao.web.model.ArticleDO;

public class ArticleDao extends SqlSessionDaoSupport  {

	public List<ArticleDO> getWXNewsList(Long userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("status", StatusType.PUBLISH);
		return this.getSqlSession().selectList("userArticle.getWXNewsList", params);
	}

	public List<ArticleDO> getNewsList(Long userId) {
		Map<String, Object> params = new HashMap<String , Object>();
		params.put("userId", userId);
		params.put("status", StatusType.PUBLISH);
		return this.getSqlSession().selectList("userArticle.getNewsList", params);
	}
	
	public List<ArticleDO> getNewsList(Long userId , Long cursor , Byte direction , Integer size) {
		Map<String, Object> params = new HashMap<String , Object>();
		params.put("userId", userId);
		params.put("cursor", cursor);
		params.put("size", size);
		params.put("status", StatusType.PUBLISH);
		return this.getSqlSession().selectList((direction!=null&&direction > 0) ? 
				"userArticle.getNewsForwardList":"userArticle.getNewsBackList", params);
	}

	public List<ArticleDO> getBannerList(Long userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("status", StatusType.PUBLISH);
		return this.getSqlSession().selectList("userArticle.getBannerList" , params);
	}
	
	public ArticleDO get(Long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("status", StatusType.PUBLISH);
		return this.getSqlSession().selectOne("userArticle.getArticleById", params);
	}

}
