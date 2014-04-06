package com.feetao.web.utils;

import java.util.Map;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;


public class WeChatCommond {

	/**
	 * 微信的APPKEY
	 */
	private static String APPID			= "wxb8d5acdf4aaf6a99";
	
	/**
	 * 微信的APPSECRET
	 */
	private static String APPSECRET		= "4aa1736c99aadf485e28c839c99fdd7e";
	
	/**
	 * 获取到的access_token
	 */
	private static String ASSESS_TOKEN	= "";
	
    public static String getAccessToken() throws Exception {
    	HttpGet request = HttpConnection.getGetMethod("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APPID + "&secret=" + APPSECRET); 
    	Map<String, String> map = HttpConnection.requestJson(request);
    	if(map.get("errcode") == null){
    		ASSESS_TOKEN = map.get("access_token");
    	}
    	System.out.println("getAccessToken:" + map);
    	return null;
    }
    
    public static boolean createMenu(String content) throws Exception {
    	HttpPost request = HttpConnection.getPostMethod("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + ASSESS_TOKEN);
    	request.setEntity(new StringEntity(content, "UTF-8"));
    	Map<String, String> map = HttpConnection.requestJson(request);
    	System.out.println(map);
    	return true;
    }

    public static void main(String[] args) throws Exception {
    	getAccessToken();
//    	String menu = "{\"button\":[" +
//    			"{\"type\":\"click\",\"name\":\"进入超市\",\"key\":\"商城\"}," +
//    			"{\"type\":\"click\",\"name\":\"投票\",\"key\":\"投票\"}," +
//    			"{\"name\":\"菜单\",\"sub_button\":[" +
//    				"{\"type\":\"view\",\"name\":\"搜索\",\"url\":\"http://www.soso.com/\"}," +
//    				"{\"type\":\"view\",\"name\":\"视频\",\"url\":\"http://v.qq.com/\"}," +
//    				"{\"type\":\"click\",\"name\":\"赞一下我们\",\"key\":\"V1001_GOOD\"}]" +
//    			"}]}";
    	String currentMenu = "{\"button\":[" +
    			"{\"type\":\"click\",\"name\":\"进入超市\",\"key\":\"商城\"}," +
    			"{\"type\":\"click\",\"name\":\"宿舍投票\",\"key\":\"投票\"}" +
    			"]}";
    	createMenu(currentMenu);
    }
	
}
