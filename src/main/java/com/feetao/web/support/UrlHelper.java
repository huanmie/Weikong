package com.feetao.web.support;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;


/**
 * url链接的工具类
 * @author feetao
 */
public class UrlHelper {


	private String url;
	
	private Map<String , String> params;
	
	public UrlHelper(String url) {
		if(url == null) return;
		String[] args = url.split("\\?");
		if(args.length > 0) this.url	= args[0];
		if(args.length > 1) {
			for(int i = 1 ; i < args.length ; i++) {
				String[] s = args[i].split("&");
				for(int j = 0 ; j < s.length ; j++) {
					String[] t = s[j].split("=");
					if(t.length == 2) {
						addQuery(t[0] , t[1]);
					}
				}
			}
		}
	}
	
	public UrlHelper addQuery(String key , Object value) {
		if(StringUtils.isBlank(key) || value==null ||StringUtils.isBlank(value.toString()))
			return this;
		if(params == null) params = new HashMap<String , String>();
		params.put(key, value.toString());
		return this;
	}
	
	@Override
	public String toString() {
		if(StringUtils.isBlank(url)) 
			return null;
		StringBuilder sb = new StringBuilder(url);
		if(params != null) {
			boolean isFirst = true;
			for(String key : params.keySet()) {
				sb.append(isFirst ? "?" : "&").append(key).append("=").append(params.get(key));
				isFirst = false;
			}
		}
		return sb.toString();
	}
	
}
