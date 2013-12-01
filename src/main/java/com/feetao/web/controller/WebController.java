package com.feetao.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.feetao.web.service.WebArticleService;
import com.feetao.web.service.WebBannerService;
import com.feetao.web.service.WebSummaryService;
import com.feetao.web.vo.WebArticle;

@Controller
@RequestMapping("/mini")
public class WebController {

	@Resource
	private WebBannerService webBannerService;

	@Resource
	private WebSummaryService webSummaryService;
	
	@Resource
	private WebArticleService webArticleService;
	
	@RequestMapping("/home")
	public ModelAndView getHome() {
		List<String> banners = webBannerService.getList(0L);
		String summary		= webSummaryService.get(0L);
		
		
		return null;
	}
	
	
	@ResponseBody
	@RequestMapping("/article/list")
	public ArrayList<WebArticle> listArticle(HttpServletRequest request , HttpServletResponse response) {
		
//		ArrayList<WebArticle> list = null;
//        try{
//        	long cursor 	= Long.MAX_VALUE;
//        	int direction	= 1;
//        	int size		= 10;
//        	
//        	try{
//        		cursor = Integer.parseInt(request.getParameter("cursor"));
//        	} catch(NumberFormatException e) {
//        	}
//        	try{
//        		direction = Integer.parseInt(request.getParameter("direction"));
//        	} catch(NumberFormatException e) {
//        	}
//        	try{
//        		size = Integer.parseInt(request.getParameter("size"));
//        	} catch(NumberFormatException e) {
//        	}
//        	
//        	list = partService.getPartList(cursor, direction, size);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//        return list;
		return null;
	}

	@RequestMapping("/article/detail")
	public ArrayList<WebArticle> getDetail(HttpServletRequest request , HttpServletResponse response) {
		webArticleService.get(0L);
		return null;
	}

	
}
