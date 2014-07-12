package com.feetao.web.service;

import java.util.List;

import com.feetao.web.vo.ShopVO;

public interface ShopService {
	
	public List<ShopVO> getShopList(Long userId , String item);
}
