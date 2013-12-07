package com.feetao.web.service;

import com.feetao.web.vo.CommonArgs;

public interface WebSummaryService {

	/**
	 * 获取用户summary
	 * @param userId
	 * @return
	 */
	public String  get(CommonArgs args);
}
