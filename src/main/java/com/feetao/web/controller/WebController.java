package com.feetao.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.feetao.web.service.ArticleService;
import com.feetao.web.support.RequestContextHolder;
import com.feetao.web.support.RequestData;
@Controller
@RequestMapping("/mini")
public class WebController {

	@Resource
	private ArticleService articleService;
	
	@Resource
	private RequestContextHolder requestContextHolder;
	
	/**
	 * 留言板
	 * @return
	 */
	@RequestMapping("/board")
	public ModelAndView getBoard() {
		RequestData data = requestContextHolder.getRequestData();
		ModelAndView mv = new ModelAndView("screen/board");
		mv.addObject("bannerList", articleService.getBannerList(data.getUserId()));
		mv.addObject("newsList" , articleService.getNewsList(data.getUserId()));
		return mv;
	}

	/**
	 * 购物车
	 * @return
	 */
	@RequestMapping("/cart")
	public ModelAndView getCart() {
		RequestData data = requestContextHolder.getRequestData();
		ModelAndView mv = new ModelAndView("screen/cart");
		mv.addObject("bannerList", articleService.getBannerList(data.getUserId()));
		mv.addObject("newsList" , articleService.getNewsList(data.getUserId()));
		return mv;
	}

	/**
	 * banner和news
	 * @return
	 */
	@RequestMapping("/news_banner")
	public ModelAndView newsBanner() {
		RequestData data = requestContextHolder.getRequestData();
		ModelAndView mv = new ModelAndView("screen/news_banner");
		mv.addObject("bannerList", articleService.getBannerList(data.getUserId()));
		mv.addObject("newsList" , articleService.getNewsList(data.getUserId()));
		return mv;
	}

	/**
	 * 详情页面
	 * @param id
	 * @return
	 */
	@RequestMapping("/detail")
	public ModelAndView detail(@RequestParam(value = "id")Long id) {
		ModelAndView mv = new ModelAndView("screen/detail");
		mv.addObject("article", articleService.get(id));
		return mv;
	}
	
	/**
	 * 会员
	 * @return
	 */
	@RequestMapping("/member")
	public ModelAndView member() {
		return new ModelAndView("screen/member");
	}
	
	/**
	 * 预约
	 * @return
	 */
	@RequestMapping("/reservation")
	public ModelAndView reservation() {
		return new ModelAndView("screen/reservation");
	}
	
	/**
	 * 订单
	 * @return
	 */
	@RequestMapping("/order")
	public ModelAndView order() {
		return new ModelAndView("screen/order");
	}
	
	/**
	 * 转盘
	 * @return
	 */
	@RequestMapping("/rotate")
	public ModelAndView rotate() {
		return new ModelAndView("screen/rotate");
	}
	
	/**
	 * 刮刮乐
	 * @return
	 */
	@RequestMapping("/scratch")
	public ModelAndView scratch() {
		return new ModelAndView("screen/scratch");
	}
	
}
