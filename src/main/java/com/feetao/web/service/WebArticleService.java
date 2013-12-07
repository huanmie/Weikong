package com.feetao.web.service;

import java.util.List;

import com.feetao.web.vo.CommonArgs;
import com.feetao.web.vo.WebArticle;

public interface WebArticleService {

	/**
	 * 获取用户文章列表
	 * @param cursor
	 * @param direction
	 * @param size
	 * @return
	 */
	public List<WebArticle> getList(CommonArgs args , Long cursor, Byte direction , Integer size);
	
	/**
	 * 获取某文章
	 * @param id
	 * @return
	 */
	public WebArticle get(CommonArgs args , Long id);
	
}
