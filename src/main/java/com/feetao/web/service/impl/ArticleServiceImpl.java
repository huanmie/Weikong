package com.feetao.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;

import com.feetao.web.dao.ArticleDao;
import com.feetao.web.model.ArticleDO;
import com.feetao.web.service.ArticleService;
import com.feetao.web.support.UrlContainer;
import com.feetao.web.vo.WebArticle;

public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleDao articleDao;
	
	@Resource
	private UrlContainer urlContainer;
	
	@Override
	public List<WebArticle> getNewsList(Long userId , Long cursor, Byte direction, Integer size) {
		List<ArticleDO> list = articleDao.getNewsList(userId, cursor, direction, size);
		if(list != null && list.size() > 0) {
			ArrayList<WebArticle> result = new ArrayList<WebArticle>();
			for(int i = 0 ; i < list.size() ; i++) 
				result.add(convert(list.get(i)));
			return result;
		}
		return null;
	}

	@Override
	public WebArticle get(Long id) {
		ArticleDO article = articleDao.get(id);
		if(article != null) {
			return convert(article);
		}
		return null;
	}

	@Override
	public List<WebArticle> getNewsList(Long userId) {
		List<ArticleDO> list = articleDao.getNewsList(userId);
		if(list != null && list.size() > 0) {
			ArrayList<WebArticle> result = new ArrayList<WebArticle>();
			for(int i = 0 ; i < list.size() ; i++)
				result.add(convert(list.get(i)));
			return result;
		}
		return null;
	}
	
	@Override
	public List<WebArticle> getBannerList(Long userId) {
		List<ArticleDO> list = articleDao.getBannerList(userId);
		if(list != null && list.size() > 0) {
			ArrayList<WebArticle> result = new ArrayList<WebArticle>();
			for(int i = 0 ; i < list.size() ; i++)
				result.add(convert(list.get(i)));
			return result;
		}
		return null;
	}
	
	private WebArticle convert(ArticleDO ado) {
		WebArticle article = new WebArticle();
		BeanUtils.copyProperties(ado, article);
		article.setLink(urlContainer.createPluginLink(article.getPlugin(), article.getId()));
		return article;
	}
}
