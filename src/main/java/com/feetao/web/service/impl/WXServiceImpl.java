package com.feetao.web.service.impl;

import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.annotation.Resource;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.feetao.web.dao.UserNewsDao;
import com.feetao.web.service.WXService;
import com.feetao.web.wx.vo.MessageEventReceiveVO;
import com.feetao.web.wx.vo.MessageImageReceiveVO;
import com.feetao.web.wx.vo.MessageLinkReceiveVO;
import com.feetao.web.wx.vo.MessageLocationReceiveVO;
import com.feetao.web.wx.vo.MessageReceiveVO;
import com.feetao.web.wx.vo.MessageSendVO;
import com.feetao.web.wx.vo.MessageTextReceiveVO;
import com.feetao.web.wx.vo.MessageVideoReceiveVO;
import com.feetao.web.wx.vo.MessageVoiceReceiveVO;

public class WXServiceImpl implements WXService {

	@Resource
//	private UserNewsDao userNewsDao;

	@Override
	public MessageReceiveVO parse(InputStream in) throws DocumentException {
		SAXReader reader 	= new SAXReader();
		Document doc 		= reader.read(in);
		Element root 		= doc.getRootElement();
		String msgType		= root.element("MsgType").getTextTrim();
		MessageReceiveVO message	= null;
		if(msgType.equalsIgnoreCase("text")) {
			message = new MessageTextReceiveVO();
		} else if(msgType.equalsIgnoreCase("image")) {
			message = new MessageImageReceiveVO();
		} else if(msgType.equalsIgnoreCase("voice")) {
			message = new MessageVoiceReceiveVO();
		} else if(msgType.equalsIgnoreCase("video")) {
			message = new MessageVideoReceiveVO();
		} else if(msgType.equalsIgnoreCase("location")) {
			message = new MessageLocationReceiveVO();
		} else if(msgType.equalsIgnoreCase("link")) {
			message = new MessageLinkReceiveVO();
		} else if(msgType.equalsIgnoreCase("event")) {
			message	= new MessageEventReceiveVO();
		}
		message.setProperties(root);
		return message;
	}

	@Override
	public MessageSendVO hander(MessageReceiveVO receiver) {
//		ArrayList<ArticleDO> articles = userNewsDao.getNewsList();
//		if(articles != null && articles.size() > 0) {
//			MessageNewsSendVO sender = new MessageNewsSendVO();
//			sender.setFromUserName(receiver.getToUserName());
//			sender.setToUserName(receiver.getFromUserName());
//			sender.setCreateTime((int)(System.currentTimeMillis()/1000));
//			sender.setMsgType("news");
//			for(int i = 0 ; i < articles.size() ; i++) {
//				Article article = new Article();
//				article.setTitle(articles.get(i).getTitle());
//				article.setDescription(articles.get(i).getDescription());
//				article.setPicUrl(articles.get(i).getPicUrl());
//				article.setUrl(articles.get(i).getUrl());
//				sender.addArticle(article);
//			}
//			return sender;
//		}
		return null;
	}

	@Override
	public boolean checkSign(String signature, String timestamp, String nonce) {
		String[] arr = new String[]{"qwerty",timestamp,nonce};  
		Arrays.sort(arr);  
		StringBuilder content = new StringBuilder();  
		for (int i = 0; i < arr.length; i++)
			content.append(arr[i]);
		
		MessageDigest md = null;
		String tmpStr = null;

		try {
			md = MessageDigest.getInstance("SHA-1");
			byte[] digest = md.digest(content.toString().getBytes());
			tmpStr = byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		content = null;
		return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
	}
	
	/**
	 * 将字节转换为十六进制字符
	 * @param ib
	 * @return
	 */
    private String byteToHexStr(byte ib) {  
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};  
        char[] ob = new char[2];  
        ob[0] = Digit[(ib >>> 4) & 0X0F];  
        ob[1] = Digit[ib & 0X0F];  
        String s = new String(ob);  
        return s;  
    }  
      
    /**
     * 将字节数组转换为十六进制字符串
     * @param bytearray
     * @return
     */
    private String byteToStr(byte[] bytearray) {  
        String strDigest = "";  
        for (int i = 0; i < bytearray.length; i++)
            strDigest += byteToHexStr(bytearray[i]);  
        return strDigest;  
    }

	
}
