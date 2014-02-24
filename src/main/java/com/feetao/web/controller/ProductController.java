package com.feetao.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feetao.web.service.ProductService;
import com.feetao.web.support.RequestContextHolder;
import com.feetao.web.support.RequestData;

/**
 * 商品
 * @author feetao
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Resource
	private ProductService productService;
	
	@Resource
	private RequestContextHolder requestContextHolder;
	
	@ResponseBody
	@RequestMapping("/ids")
	public Object listProductByIds(@RequestParam(value = "ids[]") List<Long> ids) {
		RequestData data = requestContextHolder.getRequestData();
		System.out.println("data:" + data);
		return productService.getProductList(data.getUserId(), ids);
	}

}
