package com.feetao.web.service;

import java.util.List;

import com.feetao.web.vo.OrderVO;

public interface OrderService {

	/**
	 * 获取订单列表
	 * @param userId
	 * @param openId
	 * @return
	 */
	public List<OrderVO> getOrderList(Long userId , String openId);

	/**
	 * 提交订单
	 * @param userId
	 * @param openId
	 * @param vo
	 */
	public void addOrder(Long userId, String openId, Long addressId , String content , String deliverTime , Long price);
	
	/**
	 * 更新订单
	 * @param userId
	 * @param openId
	 * @param vo
	 */
	public void updateOrder(Long id , Byte status);
}
