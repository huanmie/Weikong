package com.feetao.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.feetao.web.constants.ConstantsError;
import com.feetao.web.constants.StatusType;
import com.feetao.web.dao.OrderDao;
import com.feetao.web.exception.ServiceException;
import com.feetao.web.model.OrderDO;
import com.feetao.web.service.AddressService;
import com.feetao.web.service.OrderService;
import com.feetao.web.utils.Convert;
import com.feetao.web.vo.AddressVO;
import com.feetao.web.vo.OrderVO;

public class OrderServiceImpl implements OrderService {

	@Resource
	private AddressService addressService;
	
	@Resource
	private OrderDao orderDao;
	
	@Override
	public List<OrderVO> getOrderList(Long userId, String openId) {
		List<OrderDO> list = orderDao.getOrderList(userId , openId);
		if(list != null && list.size() > 0) {
			ArrayList<OrderVO> result = new ArrayList<OrderVO>();
			for(int i = 0 ; i < list.size() ; i++) 
				result.add(Convert.convert(OrderVO.class , list.get(i)));
			return result;
		}
		return null;
	}

	@Override
	public void addOrder(Long userId, String openId, Long addressId, String content, String deliverTime , Long price) {
		AddressVO vo = addressService.getAddressById(userId, openId, addressId);
		if(vo == null) 
			throw new ServiceException(ConstantsError.InvalidArguemnt);
		OrderDO odo = new OrderDO();
		odo.setUserId(userId);
		odo.setOpenId(openId);
		odo.setName(vo.getName());
		odo.setMobile(vo.getMobile());
		odo.setAddress(vo.getAddress());
		odo.setContent(content);
		odo.setDeliverTime(deliverTime);
		odo.setPrice(price);
		odo.setStatus(StatusType.ORDER_CREATE);
		orderDao.addOrder(odo);
	}

	@Override
	public void updateOrder(Long id, Byte status) {
		OrderDO odo = new OrderDO();
		odo.setId(id);
		odo.setStatus(status);
		orderDao.updateOrder(odo);
	}

}
