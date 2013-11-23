package com.feetao.sdk.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping()
public class MessageController {

	/**
	 * 微信的token
	 */
	private static String WEIXIN_TOKEN	= "qwerty";
	
	
	private static final String RESPONSE_TXT = "<xml><ToUserName><![CDATA[%s]]></ToUserName><FromUserName><![CDATA[%s]]></FromUserName><CreateTime>%s</CreateTime><MsgType><![CDATA[%s]]></MsgType><Content><![CDATA[%s]]></Content><FuncFlag>0</FuncFlag></xml>";  
	  
	
	/**
	 * 消息接收容器
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void dispatcher(HttpServletRequest request , HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8"); 
        response.setCharacterEncoding("UTF-8");  
        PrintWriter out = response.getWriter();
  
        Document doc = null;  
        SAXReader reader = new SAXReader();  
        InputStream in = request.getInputStream();  
        try {  
            doc = reader.read(in);  
            Element root = doc.getRootElement();  
            String toUserName = root.element("ToUserName").getTextTrim();  
            String fromUserName = root.element("FromUserName").getTextTrim();  
            String content = root.element("Content").getTextTrim();  
            // root.element("MsgType")可以获取消息类型  
            // 这里只回复简单文本信息  
            out.printf(RESPONSE_TXT, fromUserName,toUserName,System.currentTimeMillis(),"text","您发送的内容是:"+content);  
        } catch (DocumentException e) {  
            e.printStackTrace();  
        }  
        in.close();  
        in = null;  
        out.close();  
        out = null;  
	}
	
	/**
	 * 校验微信签名
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public boolean checkSignature(String signature , String timestamp , String nonce) {  
		String[] arr = new String[]{WEIXIN_TOKEN,timestamp,nonce};  
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
	
