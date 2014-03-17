package com.feetao.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.feetao.web.service.AddressService;
import com.feetao.web.service.ArticleService;
import com.feetao.web.service.OrderService;
import com.feetao.web.service.ProductService;
import com.feetao.web.support.RequestContextHolder;
import com.feetao.web.support.RequestData;
import com.feetao.web.vo.ProductVO;

/**
 * web页面
 * @author feetao
 */
@Controller
@RequestMapping("/mini")
public class WebController {

	@Resource
	private ProductService productService;
	
	@Resource
	private AddressService addressService;
	
	@Resource
	private OrderService orderService;
	
	@Resource
	private ArticleService articleService;
	
	@Resource
	private RequestContextHolder requestContextHolder;

	/**
	 * 商品
	 * @return
	 */
	@RequestMapping("/product")
	public ModelAndView getProduct() {
		RequestData data = requestContextHolder.getRequestData();
		ModelAndView mv = new ModelAndView("screen/product");
		mv.addObject("productList", productService.getProductList(data.getUserId()));
		return mv;
	}

	/**
	 * 购物车
	 * @return
	 */
	@RequestMapping("/cart")
	public ModelAndView getCart(@CookieValue(value="cart", required= false, defaultValue="") String cart) {
		RequestData data = requestContextHolder.getRequestData();
		ModelAndView mv = new ModelAndView("screen/cart");
		try {
			@SuppressWarnings("unchecked")
			Map<Long, Integer> maps = new ObjectMapper().readValue(cart, Map.class);
			List<ProductVO> products  = productService.getProductList(data.getUserId(), new ArrayList<Long>(maps.keySet()));
			mv.addObject("productList", products);
		} catch (Exception e) {}
		mv.addObject("addressList", addressService.getAddressList(data.getUserId(), data.getOpenId()));
		return mv;
	}
		
	/**
	 * 订单
	 * @return
	 */
	@RequestMapping("/order")
	public ModelAndView getOrder() {
		RequestData data = requestContextHolder.getRequestData();
		ModelAndView mv = new ModelAndView("screen/order");
		mv.addObject("orderList", orderService.getOrderList(data.getUserId() , data.getOpenId()));
		return mv;
	}

//	/**
//	 * 留言板
//	 * @return
//	 */
//	@RequestMapping("/board")
//	public ModelAndView getBoard() {
//		RequestData data = requestContextHolder.getRequestData();
//		ModelAndView mv = new ModelAndView("screen/board");
//		return mv;
//	}
	
	/**
	 * banner和news
	 * @return
	 */
	@RequestMapping("/news_banner")
	public ModelAndView newsBanner() {
		RequestData data = requestContextHolder.getRequestData();
		ModelAndView mv = new ModelAndView("screen/news_banner");
		mv.addObject("bannerList", articleService.getBannerList(data.getUserId()));
		mv.addObject("newsList" , articleService.getNewsList(data.getUserId() , "article"));
		return mv;
	}

	/**
	 * 详情
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
	 * 预订
	 * @return
	 */
	@RequestMapping("/reservation")
	public ModelAndView reservation() {
		return new ModelAndView("screen/reservation");
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
