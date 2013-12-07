package com.feetao.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.feetao.web.dao.UserWebBannerDao;
import com.feetao.web.service.WebBannerService;
import com.feetao.web.vo.CommonArgs;

public class WebBannerServiceImpl implements WebBannerService {

	@Resource
	private UserWebBannerDao userWebBannerDao;
	
	@Override
	public List<String> getList(CommonArgs args) {
		return userWebBannerDao.getOnlineList(args.getUserId());
	}

}
