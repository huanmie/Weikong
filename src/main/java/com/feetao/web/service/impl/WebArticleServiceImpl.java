package com.feetao.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;

import com.feetao.web.dao.UserWebArticleDao;
import com.feetao.web.model.UserWebArticleDO;
import com.feetao.web.service.WebArticleService;
import com.feetao.web.vo.CommonArgs;
import com.feetao.web.vo.WebArticle;

public class WebArticleServiceImpl implements WebArticleService {

	@Resource
	private UserWebArticleDao userWebArticleDao;
	
	@Override
	public List<WebArticle> getList(CommonArgs args , Long cursor, Byte direction, Integer size) {
		ArrayList<UserWebArticleDO> articlelist = userWebArticleDao.getList(args.getUserId() , cursor, direction, size);
		if(articlelist != null && articlelist.size() > 0) {
			ArrayList<WebArticle> result = new ArrayList<WebArticle>();
			for(int i = 0 ; i < articlelist.size() ; i++) {
				WebArticle article = new WebArticle();
				BeanUtils.copyProperties(articlelist.get(i), article);
				result.add(article);
			}
			return result;
		}

		return null;
	}

	@Override
	public WebArticle get(CommonArgs args , Long id) {
		UserWebArticleDO article = userWebArticleDao.get(id);
		if(article != null) {
			WebArticle artic = new WebArticle();
			BeanUtils.copyProperties(article, artic);
			return artic;
		}
		return null;
	}

}
