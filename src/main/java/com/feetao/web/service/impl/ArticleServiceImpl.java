package com.feetao.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;

import com.feetao.web.dao.ArticleDao;
import com.feetao.web.model.ArticleDO;
import com.feetao.web.service.ArticleService;
import com.feetao.web.support.UrlContainer;
import com.feetao.web.vo.ArticleVO;

public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleDao articleDao;
	
	@Resource
	private UrlContainer urlContainer;
	
//	@Override
//	public List<ArticleVO> getNewsList(Long userId , String item , Long cursor, Byte direction, Integer size) {
//		List<ArticleDO> list = articleDao.getNewsList(userId, item , cursor, direction, size);
//		if(list != null && list.size() > 0) {
//			ArrayList<ArticleVO> result = new ArrayList<ArticleVO>();
//			for(int i = 0 ; i < list.size() ; i++) 
//				result.add(convert(list.get(i)));
//			return result;
//		}
//		return null;
//	}

	@Override
	public ArticleVO get(Long id) {
		ArticleDO article = articleDao.get(id);
		if(article != null) {
			return convert(article);
		}
		return null;
	}

	@Override
	public List<ArticleVO> getNewsList(Long userId, String item) {
		List<ArticleDO> list = articleDao.getNewsList(userId , item);
		if(list != null && list.size() > 0) {
			ArrayList<ArticleVO> result = new ArrayList<ArticleVO>();
			for(int i = 0 ; i < list.size() ; i++)
				result.add(convert(list.get(i)));
			return result;
		}
		return null;
	}
	
	@Override
	public List<ArticleVO> getBannerList(Long userId) {
		List<ArticleDO> list = articleDao.getBannerList(userId);
		if(list != null && list.size() > 0) {
			ArrayList<ArticleVO> result = new ArrayList<ArticleVO>();
			for(int i = 0 ; i < list.size() ; i++)
				result.add(convert(list.get(i)));
			return result;
		}
		return null;
	}
	
	private ArticleVO convert(ArticleDO ado) {
		ArticleVO article = new ArticleVO();
		BeanUtils.copyProperties(ado, article);
		article.setLink(urlContainer.createPluginLink(article.getPlugin(), article.getId()));
		return article;
	}
}
