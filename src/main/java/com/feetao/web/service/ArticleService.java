package com.feetao.web.service;

import java.util.List;

import com.feetao.web.vo.WebArticle;

public interface ArticleService {

	/**
	 * 获取用户news
	 * @param args
	 * @return
	 */
	public List<WebArticle> getNewsList(Long userId);
	
	/**
	 * 获取用户文章列表
	 * @param cursor
	 * @param direction
	 * @param size
	 * @return
	 */
	public List<WebArticle> getNewsList(Long userId , Long cursor, Byte direction , Integer size);
	
	/**
	 * 获取某文章
	 * @param id
	 * @return
	 */
	public WebArticle get(Long id);
	
	/**
	 * 获取用户banner列表
	 * @param userId
	 * @return
	 */
	public List<WebArticle> getBannerList(Long userId);
}
