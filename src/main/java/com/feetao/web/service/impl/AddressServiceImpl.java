package com.feetao.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.feetao.web.constants.StatusType;
import com.feetao.web.dao.AddressDao;
import com.feetao.web.model.AddressDO;
import com.feetao.web.service.AddressService;
import com.feetao.web.utils.Convert;
import com.feetao.web.vo.AddressVO;

public class AddressServiceImpl implements AddressService {

	@Resource
	private AddressDao addressDao;
	
	@Override
	public List<AddressVO> getAddressList(Long userId, String openId) {
		List<AddressDO> list = addressDao.getAddressList(userId , openId);
		if(list != null && list.size() > 0) {
			ArrayList<AddressVO> result = new ArrayList<AddressVO>();
			for(int i = 0 ; i < list.size() ; i++)
				result.add(Convert.convert(AddressVO.class , list.get(i)));
			return result;
		}
		return null;
	}

	@Override
	public AddressVO getAddressById(Long userId, String openId, Long addressId) {
		AddressDO ado = addressDao.getAddressById(userId,openId,addressId);
		return Convert.convert(AddressVO.class, ado);
	}

	@Override
	public AddressVO getDefaultAddress(Long userId, String openId) {
		AddressDO ado = addressDao.getDefaultAddress(userId, openId);
		return Convert.convert(AddressVO.class, ado);
	}
	
	@Override
	public AddressVO addAddress(Long userId, String openId, String name, String mobile, String address) {
		AddressDO ado = new AddressDO();
		ado.setUserId(userId);
		ado.setOpenId(openId);
		ado.setName(name);
		ado.setMobile(mobile);
		ado.setAddress(address);
		addressDao.addAddress(ado);
		return Convert.convert(AddressVO.class, ado);
	}


	@Override
	public void updateAddress(Long userId, String openId, Long id, String name, String mobile, String address) {
		AddressDO ado = new AddressDO();
		ado.setUserId(userId);
		ado.setOpenId(openId);
		ado.setId(id);
		ado.setName(name);
		ado.setMobile(mobile);
		ado.setAddress(address);
		addressDao.updateAddress(ado);
	}

	@Override
	public void setAddress(Long userId , String openId , Long id) {
		addressDao.setAddress(userId, openId, id);
	}

	@Override
	public void removeAddress(Long userId, String openId, Long id) {
		AddressDO ado = new AddressDO();
		ado.setUserId(userId);
		ado.setOpenId(openId);
		ado.setId(id);
		ado.setStatus(StatusType.REMOVED);
		addressDao.updateAddress(ado);
	}
	
}
