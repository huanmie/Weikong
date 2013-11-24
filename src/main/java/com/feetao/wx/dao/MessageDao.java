package com.feetao.wx.dao;

import java.util.ArrayList;

import com.feetao.wx.model.ArticleDO;

public interface MessageDao {

	/**
	 * 获取输出给用户的图文消息
	 * @return
	 */
	public ArrayList<ArticleDO> getNewsItem();

}
