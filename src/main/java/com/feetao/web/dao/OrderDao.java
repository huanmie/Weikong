package com.feetao.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.feetao.web.model.OrderDO;

public class OrderDao extends SqlSessionDaoSupport {

	public List<OrderDO> getOrderList(Long userId , String openId) {
		Map<String, Object> params = new HashMap<String , Object>();
		params.put("userId", userId);
		params.put("openId", openId);
		return this.getSqlSession().selectList("order.getOrderList", params);
	}
	
	public void addOrder(OrderDO order) {
		this.getSqlSession().insert("order.addOrder", order);
	}

	public void updateOrder(OrderDO order) {
		this.getSqlSession().update("order.updateOrder", order);
	}
	
}
