package com.feetao.web.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.feetao.web.service.AddressService;
import com.feetao.web.service.BannerService;
import com.feetao.web.service.BoardService;
import com.feetao.web.service.ItemService;
import com.feetao.web.service.MemberService;
import com.feetao.web.service.OrderService;
import com.feetao.web.service.ProductService;
import com.feetao.web.service.ShopService;
import com.feetao.web.support.RequestContextHolder;
import com.feetao.web.support.RequestData;
import com.feetao.web.vo.MemberVO;

/**
 * web页面
 * @author feetao
 */
@Controller
@RequestMapping("/mini")
public class WebController {

	private static Logger logger = LoggerFactory.getLogger(WebController.class);

	@Resource
	private AddressService addressService;
	
	@Resource
	private BannerService bannerService;
	
	@Resource
	private BoardService boardService;
	
	@Resource
	private ItemService itemService;
	
	@Resource
	private MemberService memberService;
	
	@Resource
	private OrderService orderService;
	
	@Resource
	private ProductService productService;

	@Resource
	private ShopService shopService;
	
	@Resource
	private RequestContextHolder requestContextHolder;

	/**
	 * 分类
	 * @return
	 */
	@RequestMapping("/item")
	public ModelAndView getItem() {
		RequestData data = requestContextHolder.getRequestData();
		ModelAndView mv = new ModelAndView("screen/item");		
		mv.addObject("bannerList" , bannerService.getBannerList(data.getUserId()));
		mv.addObject("itemList" , itemService.getItemList(data.getUserId()));
		return mv;
	}
	
	/**
	 * 店铺
	 * @param item
	 * @return
	 */
	@RequestMapping("/shop/{item}")
	public ModelAndView getShop(@PathVariable("item") String item) {
		RequestData data = requestContextHolder.getRequestData();
		ModelAndView mv = new ModelAndView("screen/shop");
		mv.addObject("shopList" , shopService.getShopList(data.getUserId() , item));
		return mv;
	}
	
	/**
	 * 商品
	 * @param item
	 * @return
	 */
	@RequestMapping("/product/{item}")
	public ModelAndView getMarket(@PathVariable("item") String item) {
		RequestData data = requestContextHolder.getRequestData();
		ModelAndView mv = new ModelAndView("screen/market");
		mv.addObject("productList", productService.getProductList(data.getUserId() , item));
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
			mv.addObject("address",addressService.getDefaultAddress(data.getUserId(), data.getOpenId()));
			mv.addObject("productList", productService.getProductList(data.getUserId(), new ArrayList<Long>(maps.keySet())));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return mv;
	}
	
	@RequestMapping("/address") 
	public ModelAndView getAddress(){
		RequestData data = requestContextHolder.getRequestData();
		ModelAndView mv = new ModelAndView("screen/address");
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

	/**
	 * 留言板
	 * @return
	 */
	@RequestMapping("/board")
	public ModelAndView getBoard(@RequestParam("cursor") Long cursor, @RequestParam("size") int size) {
		RequestData data = requestContextHolder.getRequestData();
		ModelAndView mv = new ModelAndView("screen/board");
		mv.addObject("messageList", boardService.getMessageList(data.getUserId(), cursor , size));
		return mv;
	}
	
	/**
	 * 会员信息
	 * @return
	 */
	@RequestMapping("/member")
	public ModelAndView getMember() {
		RequestData data = requestContextHolder.getRequestData();
		ModelAndView mv = new ModelAndView("screen/member");
		MemberVO mvo = memberService.getMember(data.getUserId(), data.getOpenId());
		mv.addObject("member" , mvo);
		return mv;
	}
	
}
