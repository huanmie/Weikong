package com.feetao.web.support;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.feetao.web.constants.Constants;
import com.feetao.web.utils.Signer;

public class UrlContainer {

	private Map<String, String> urls = new HashMap<String, String>();

	public Map<String, String> getUrls() {
		return urls;
	}

	public void setUrls(Map<String, String> urls) {
		this.urls = urls;
	}
	
	public String get(String key) {
		if(!key.toLowerCase().startsWith("http")) {
			key = urls.get(key);
			if(StringUtils.isBlank(key)) 
				key = urls.get("news_banner"); 
		}
		return key;
	}

	public RequestData parserCookie(String cookieValue) {
		try{
			if(StringUtils.isBlank(cookieValue)) return null;
			String[] values = cookieValue.split(Constants.COOKIESPLIT);
			long userId 	= Long.parseLong(values[0]);
			String openId	= values[1];
			String pubId	= values[2];
			String sign		= values[3];
			String tsign	= Signer.getSign(userId + openId + pubId + Constants.COOKIEFIXSALT);
			if(!tsign.equals(sign)) return null;
			RequestData data = new RequestData();
			data.setUserId(userId);
			data.setOpenId(openId);
			data.setPubId(pubId);
			return data;
		}catch(Exception e) {
		}
		return null;
	}

	public String createComingLink(String key , Long userId,  String openId , String pubId) {
		String tsign	= Signer.getSign(userId + openId + pubId + Constants.COOKIEFIXSALT);
		StringBuilder sb = new StringBuilder(get(key));
		sb.append("?").append(Constants.COOKIEKEY).append("=").append(userId).append(Constants.COOKIESPLIT).append(openId).append(Constants.COOKIESPLIT).append(pubId)
		.append(Constants.COOKIESPLIT).append(tsign).append(urls.get("anchor"));
		return sb.toString();
	}
	
	public String createPluginLink(String key , Long id) {
		if(StringUtils.isBlank(key)) key = "detail";
		StringBuilder sb = new StringBuilder(get(key));
		sb.append("?").append("id").append("=").append(id).append(urls.get("anchor"));
		return sb.toString();
	}

}
