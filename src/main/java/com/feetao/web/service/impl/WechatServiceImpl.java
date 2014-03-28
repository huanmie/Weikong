package com.feetao.web.service.impl;

import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.BeanUtils;

import com.feetao.web.dao.WechatDao;
import com.feetao.web.model.WechatDO;
import com.feetao.web.service.WechatService;
import com.feetao.web.support.UrlContainer;
import com.feetao.web.wx.vo.Article;
import com.feetao.web.wx.vo.MessageEventReceiveVO;
import com.feetao.web.wx.vo.MessageImageReceiveVO;
import com.feetao.web.wx.vo.MessageLinkReceiveVO;
import com.feetao.web.wx.vo.MessageLocationReceiveVO;
import com.feetao.web.wx.vo.MessageNewsSendVO;
import com.feetao.web.wx.vo.MessageReceiveVO;
import com.feetao.web.wx.vo.MessageSendVO;
import com.feetao.web.wx.vo.MessageTextReceiveVO;
import com.feetao.web.wx.vo.MessageTextSendVO;
import com.feetao.web.wx.vo.MessageVideoReceiveVO;
import com.feetao.web.wx.vo.MessageVoiceReceiveVO;

public class WechatServiceImpl implements WechatService {

	@Resource
	private WechatDao wechatDao;
	
	@Resource
	private UrlContainer urlContainer;
	
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
	public MessageSendVO hander(Long userId , MessageReceiveVO receiver) {
		List<WechatDO> chatList = wechatDao.getWechatList(userId);
		if(chatList != null && chatList.size() > 0) {
			MessageSendVO sender = null;
			WechatDO wdo = null;
			for(int i = 0 ; i < chatList.size() ; i++) {
				WechatDO cdo = chatList.get(i);
				if(cdo.getMsgKey().equals(".*")) {
					wdo = cdo;
					continue;
				}
				Matcher matcher = Pattern.compile(cdo.getMsgKey()).matcher(receiver.toString());
				if(matcher.find()) {
					wdo = cdo;
					break;
				}
			}
			if(wdo != null) {
				if(wdo.getMsgType().equals("news")) {
					sender = new MessageNewsSendVO();
					Article article = new Article();
					BeanUtils.copyProperties(wdo, article);
					if(StringUtils.isBlank(article.getUrl()))
						article.setUrl(urlContainer.createComingLink(wdo.getPlugin(), userId, receiver.getFromUserName(), receiver.getToUserName()));
					((MessageNewsSendVO)sender).addArticle(article);
				} else if(wdo.getMsgType().equals("text")) {
					sender = new MessageTextSendVO();
					((MessageTextSendVO)sender).setContent(wdo.getDescription());
				}
				sender.setFromUserName(receiver.getToUserName());
				sender.setToUserName(receiver.getFromUserName());
				sender.setCreateTime((int)(System.currentTimeMillis()/1000));
				sender.setMsgType(wdo.getMsgType());
			}
			return sender;
		}
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
