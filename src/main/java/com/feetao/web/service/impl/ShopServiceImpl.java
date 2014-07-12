package com.feetao.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.feetao.web.dao.ShopDao;
import com.feetao.web.model.ShopDO;
import com.feetao.web.service.ShopService;
import com.feetao.web.utils.Convert;
import com.feetao.web.vo.ShopVO;

public class ShopServiceImpl implements ShopService {

	@Resource
	private ShopDao shopDao;
	
	@Override
	public List<ShopVO> getShopList(Long userId , String item) {
		List<ShopDO> list = shopDao.getShopList(userId , item);
		if(list != null && list.size() > 0) {
			ArrayList<ShopVO> result = new ArrayList<ShopVO>();
			for(int i = 0 ; i < list.size() ; i++) 
				result.add(Convert.convert(ShopVO.class , list.get(i)));
			return result;
		}
		return null;
	}

}
