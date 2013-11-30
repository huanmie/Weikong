package com.feetao.web.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feetao.web.service.ArticleService;
import com.feetao.web.vo.WebArticle;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Resource
	private ArticleService articleService;

	@ResponseBody
	@RequestMapping("/list")
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
	
	
}
