package com.feetao.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.feetao.web.service.WebArticleService;
import com.feetao.web.service.WebBannerService;
import com.feetao.web.service.WebSummaryService;
import com.feetao.web.vo.CommonArgs;
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
	
	/**
	 * 渲染首页，banner和summary
	 * @param args
	 * @return
	 */
	@RequestMapping("/home")
	public ModelAndView getHome(CommonArgs args) {
		ModelAndView mv = new ModelAndView("screen/home");
		mv.addObject("banners", webBannerService.getList(args));
		mv.addObject("summary", webSummaryService.get(args));
		return mv;
	}

	/**
	 * 产品详情页面
	 * @param args
	 * @param id
	 * @return
	 */
	@RequestMapping("/article/panel")
	public ModelAndView getArticle(CommonArgs args) {
		ModelAndView mv = new ModelAndView("screen/article");
		return mv;
	}

	/**
	 * 产品详情页面
	 * @param args
	 * @param id
	 * @return
	 */
	@RequestMapping("/article/detail")
	public ModelAndView getArticleDetail(CommonArgs args , @RequestParam(value = "id")Long id) {
		ModelAndView mv = new ModelAndView("screen/article");
		mv.addObject("article", webArticleService.get(args , id));
		return mv;
	}
	
	/**
	 * 产品列表JSON
	 * @param args
	 * @param cursor
	 * @param direction
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/article/list")
	public List<WebArticle> listArticle(CommonArgs args , @RequestParam(value = "cursor", required = false , defaultValue="9223372036854775807") Long cursor , 
			@RequestParam(value = "direction", required = false , defaultValue="1") Byte direction , 
			@RequestParam(value = "size", required = false , defaultValue="10") Integer size) {
		List<WebArticle> list = webArticleService.getList(args , cursor, direction, size);
		return list;
	}
	
}
