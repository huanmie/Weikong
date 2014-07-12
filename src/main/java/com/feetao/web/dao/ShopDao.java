package com.feetao.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.feetao.web.constants.StatusType;
import com.feetao.web.model.ShopDO;

public class ShopDao extends SqlSessionDaoSupport {

	public List<ShopDO> getShopList(Long userId , String item) {
		Map<String, Object> params = new HashMap<String , Object>();
		params.put("userId", userId);
		params.put("item", item);
		params.put("status", StatusType.ONLINE);
		return this.getSqlSession().selectList("shop.getShopList", params);
	}

}
