package com.feetao.web.service;

import java.util.List;

public interface WebBannerService {

	/**
	 * 获取用户banner列表
	 * @param userId
	 * @return
	 */
	public List<String> getList(Long userId);
}
