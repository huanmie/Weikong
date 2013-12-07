package com.feetao.web.service.impl;

import javax.annotation.Resource;

import com.feetao.web.dao.UserWebSummaryDao;
import com.feetao.web.service.WebSummaryService;
import com.feetao.web.vo.CommonArgs;

public class WebSummaryServiceImpl implements WebSummaryService {

	@Resource
	private UserWebSummaryDao userWebSummaryDao;
	
	@Override
	public String get(CommonArgs args) {
		return userWebSummaryDao.getOnline(args.getUserId());
	}

}
