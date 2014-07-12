package com.feetao.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.feetao.web.constants.StatusType;
import com.feetao.web.model.AddressDO;

public class AddressDao extends SqlSessionDaoSupport {

	public List<AddressDO> getAddressList(Long userId , String openId) {
		Map<String, Object> params = new HashMap<String , Object>();
		params.put("userId", userId);
		params.put("openId", openId);
		params.put("status", StatusType.ONLINE);
		return this.getSqlSession().selectList("address.getAddressList", params);
	}

	public void addAddress(AddressDO address) {
		address.setStatus(StatusType.ONLINE);
		this.getSqlSession().insert("address.addAddress", address);
	}
	
	public void setAddress(Long userId , String openId , Long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("openId", openId);
		params.put("id", id);
		this.getSqlSession().update("address.updateUndefault" , params);
		this.getSqlSession().update("address.updateDefault" , params);
	}
	
	public AddressDO getDefaultAddress(Long userId , String openId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("openId", openId);
		params.put("status", StatusType.ONLINE);
		return this.getSqlSession().selectOne("address.getDefaultAddress" , params);
	}
	
	public AddressDO getAddressById(Long userId , String openId, Long id) {
		Map<String, Object> params = new HashMap<String , Object>();
		params.put("userId", userId);
		params.put("openId", openId);
		params.put("id", id);
		return this.getSqlSession().selectOne("address.getAddressById", params);
	}
	
	public void updateAddress(AddressDO address) {
		this.getSqlSession().update("address.updateAddress", address);
	}
	
}
