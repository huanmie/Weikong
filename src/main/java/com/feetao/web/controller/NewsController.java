package com.feetao.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feetao.web.service.ArticleService;
import com.feetao.web.support.RequestData;
import com.feetao.web.vo.WebArticle;

/**
 * 图文列表
 * @author feetao
 */
@Controller
@RequestMapping("/news")
public class NewsController {

	@Resource
	private ArticleService articleService;

	/**
	 * 产品列表JSON
	 * @param args
	 * @param cursor
	 * @param direction
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<WebArticle> listArticle(RequestData data, @RequestParam(value = "cursor", required = false , defaultValue="9223372036854775807") Long cursor , 
			@RequestParam(value = "direction", required = false , defaultValue="1") Byte direction , 
			@RequestParam(value = "size", required = false , defaultValue="10") Integer size) {
		return articleService.getNewsList(data.getUserId() , cursor, direction, size);
	}

}
