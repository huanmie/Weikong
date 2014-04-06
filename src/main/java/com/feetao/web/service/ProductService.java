package com.feetao.web.service;

import java.util.List;

import com.feetao.web.vo.ProductVO;

public interface ProductService {

	/**
	 * 获取用户产品
	 * @return
	 */
	public List<ProductVO> getProductList(Long userId , String item);
	
	/**
	 * 获取用户产品
	 * @return
	 */
	public List<ProductVO> getProductList(Long userId , List<Long> ids);
}
