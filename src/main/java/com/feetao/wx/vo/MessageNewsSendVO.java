package com.feetao.wx.vo;

import java.util.ArrayList;

public class MessageNewsSendVO extends MessageSendVO {
	
	private ArrayList<Article> articles = new ArrayList<Article>();
	
	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}
	
	public void addArticle(Article article) {
		articles.add(article);
	}

	@Override
	public String toXML() {
		StringBuilder sb	= new StringBuilder("<xml>");
		sb.append("<ToUserName><![CDATA[").append(this.toUserName).append("]]></ToUserName>");
		sb.append("<FromUserName><![CDATA[").append(this.fromUserName).append("]]></FromUserName>");
		sb.append("<CreateTime>").append(this.createTime).append("</CreateTime>");
		sb.append("<MsgType><![CDATA[").append(this.msgType).append("]]></MsgType>");
		sb.append("<ArticleCount><![CDATA[").append(articles == null ? 0 : articles.size()).append("]]></ArticleCount>");
		sb.append("<Articles>");
		if(articles != null && articles.size() > 0) {
			for(int i = 0 ; i < articles.size() ; i++) {
				Article article = articles.get(i);
				if(article != null) article.toXML(sb);
			}
		}
		sb.append("</Articles>");
		sb.append("</xml>");
		return sb.toString();
	}

}
