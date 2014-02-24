package com.feetao.web.service;

import java.util.List;

import com.feetao.web.vo.ArticleVO;

public interface ArticleService {

	/**
	 * 获取用户news
	 * @param args
	 * @return
	 */
	public List<ArticleVO> getNewsList(Long userId , String item);
	
//	/**
//	 * 获取用户文章列表
//	 * @param cursor
//	 * @param direction
//	 * @param size
//	 * @return
//	 */
//	public List<ArticleVO> getNewsList(Long userId , String item , Long cursor, Byte direction , Integer size);
//	
	/**
	 * 获取某文章
	 * @param id
	 * @return
	 */
	public ArticleVO get(Long id);
	
	/**
	 * 获取用户banner列表
	 * @param userId
	 * @return
	 */
	public List<ArticleVO> getBannerList(Long userId);
}
