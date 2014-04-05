package com.feetao.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feetao.web.constants.Result;
import com.feetao.web.service.OrderService;
import com.feetao.web.service.ProductService;
import com.feetao.web.support.RequestContextHolder;
import com.feetao.web.support.RequestData;
import com.feetao.web.vo.ProductVO;

/**
 * 订单
 * @author feetao
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Resource
	private OrderService orderService;
	
	@Resource
	private RequestContextHolder requestContextHolder;
	
	@Resource
	private ProductService productService;

	@ResponseBody
	@RequestMapping("/add")
	public Object createOrder(@CookieValue(value="cart", required= false, defaultValue="") String cart , @RequestParam("addressId") Long addressId , @RequestParam("deliverTime") String deliverTime) {
		RequestData data = requestContextHolder.getRequestData();
		try {
			@SuppressWarnings("unchecked")
			Map<String, Integer> map  = new ObjectMapper().readValue(cart, Map.class);
			Map<Long , Integer> tMap = new HashMap<Long, Integer>();
			Iterator<String> iterator = map.keySet().iterator();
		    while (iterator.hasNext()) {
		    	String key = iterator.next();
		    	tMap.put(Long.parseLong(key), map.get(key));
		    }
			if(tMap.size() > 0) {
				StringBuilder sb = new StringBuilder();
				List<ProductVO> list = productService.getProductList(data.getUserId(), new ArrayList<Long>(tMap.keySet()));
				if(list == null) return null;
				Long totalPrice = 0L;
				for(int i = 0 ; i < list.size() ; i++) {
					ProductVO p = list.get(i);
					int num = tMap.get(p.getId());
					totalPrice += (p.getPrice()*num);
					sb.append(p.getTitle()).append("(").append(num).append(p.getUnit()).append(")").append(",");
				}
				sb.deleteCharAt(sb.length()-1);
				orderService.addOrder(data.getUserId() , data.getOpenId() , addressId , sb.toString(), deliverTime , totalPrice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Result();
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public Object updateOrder(@RequestParam("id") Long id , @RequestParam("status") Byte status) {
		orderService.updateOrder(id, status);
		return new Result();
	}
	
}
