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
import org.springframework.web.bind.annotation.ResponseBody;

import com.feetao.web.constants.ConstantsError;
import com.feetao.web.constants.Result;
import com.feetao.web.exception.ServiceException;
import com.feetao.web.service.OrderService;
import com.feetao.web.service.ProductService;
import com.feetao.web.support.RequestContextHolder;
import com.feetao.web.support.RequestData;
import com.feetao.web.vo.ProductVO;

/**
 * 订单功能
 * <p>Title: OrderController.java</p>
 * <p>Description: </p>
 * @author yida.zyd
 * @date 2014-4-8
 * @version 1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Resource
	private OrderService orderService;
	
	@Resource
	private ProductService productService;
	
	@Resource
	private RequestContextHolder requestContextHolder;

	@ResponseBody
	@RequestMapping("/add")
	public Object createOrder(@CookieValue(value="cart", required= false, defaultValue="") String cart , @RequestParam("addressId") Long addressId , @RequestParam("deliverTime") String deliverTime) throws Exception {
		Result<Object> result = new Result<Object>();
		RequestData data = requestContextHolder.getRequestData();
		@SuppressWarnings("unchecked")
		Map<Long, Integer> map  = new ObjectMapper().readValue(cart, Map.class);
		if(map == null || map.size() == 0) 
			throw new ServiceException(ConstantsError.InvalidArguemnt);
		List<ProductVO> list = productService.getProductList(data.getUserId(), new ArrayList<Long>(map.keySet()));
		if(list == null || list.size() == 0) 
			throw new ServiceException(ConstantsError.InvalidArguemnt);
		
		StringBuilder sb = new StringBuilder();
		Long totalPrice = 0L;
		for(int i = 0 ; i < list.size() ; i++) {
			ProductVO p = list.get(i);
			int num = map.get(String.valueOf(p.getId()));
			totalPrice += (p.getPrice()*num);
			sb.append(p.getTitle()).append("(").append(num).append(p.getUnit()).append(")").append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		orderService.addOrder(data.getUserId() , data.getOpenId() , addressId , sb.toString(), deliverTime , totalPrice);
		return result;
	}
	
}
