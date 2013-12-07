package com.feetao.web.service;

import com.feetao.web.vo.CommonArgs;

public interface CommonService {

	/**
	 * 生成带固定参数的url
	 * @param url
	 * @param uid
	 * @param chatfrom
	 * @param chatto
	 * @return
	 */
	public String url(String url , CommonArgs args);

}
