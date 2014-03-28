package com.feetao.web.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

public class HttpConnection {

    /** 
     * 模拟浏览器post提交 
     * @param url 
     * @return 
     */  
    public static HttpPost getPostMethod(String url) {  
        HttpPost pmethod = new HttpPost(url); // 设置响应头信息  
        pmethod.addHeader("Connection", "keep-alive");  
        pmethod.addHeader("Accept", "*/*");  
        pmethod.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");  
        pmethod.addHeader("Host", "mp.weixin.qq.com");  
        pmethod.addHeader("X-Requested-With", "XMLHttpRequest");  
        pmethod.addHeader("Cache-Control", "max-age=0");  
        pmethod.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");  
        return pmethod;  
    }  
    
    /**  
     * 模拟浏览器GET提交  
     * @param url  
     * @return  
     */  
    public static HttpGet getGetMethod(String url) {
        HttpGet pmethod = new HttpGet(url);  
        pmethod.addHeader("Connection", "keep-alive");  
        pmethod.addHeader("Cache-Control", "max-age=0");  
        pmethod.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");  
        pmethod.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/;q=0.8");  
        return pmethod;  
    }
    
    @SuppressWarnings("unchecked")
	public static Map<String, String> requestJson(HttpRequestBase request) throws Exception {
    	//创建HttpClientBuilder  
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
        //HttpClient  
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
    	HttpResponse httpResponse = closeableHttpClient.execute(request);
    	//获取响应消息实体  
        HttpEntity entity = httpResponse.getEntity();
        //判断响应实体是否为空  
        Map<String, String> map = new HashMap<String, String>();
        if (entity != null) {
        	map  = new ObjectMapper().readValue(EntityUtils.toString(entity), Map.class);
        }
        closeableHttpClient.close();
        return map;
    }
}
