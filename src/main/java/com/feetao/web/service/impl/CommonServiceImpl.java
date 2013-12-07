package com.feetao.web.service.impl;

import com.feetao.web.service.CommonService;
import com.feetao.web.support.UrlHelper;
import com.feetao.web.vo.CommonArgs;

public class CommonServiceImpl implements CommonService {

	@Override
	public String url(String url, CommonArgs args) {
		UrlHelper helper = new UrlHelper(url)
				.addQuery(CommonArgs.UID, args.getUserId())
				.addQuery(CommonArgs.USERCHATID, args.getUserChatId())
				.addQuery(CommonArgs.PUBCHATID, args.getPubChatId());
		return helper.toString();
	}

}
