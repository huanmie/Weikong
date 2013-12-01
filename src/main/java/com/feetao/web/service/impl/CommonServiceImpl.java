package com.feetao.web.service.impl;

import com.feetao.web.service.CommonService;
import com.feetao.web.support.UrlHelper;

public class CommonServiceImpl implements CommonService {

	@Override
	public String url(String url, Long uid, String chatfrom, String chatto) {
		UrlHelper helper = new UrlHelper(url).addQuery("uid", uid)
				.addQuery("chatfrom", chatfrom).addQuery("chatto", chatto);
		return helper.toString();
	}

}
