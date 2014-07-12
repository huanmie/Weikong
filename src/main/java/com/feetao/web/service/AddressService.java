package com.feetao.web.service;

import java.util.List;

import com.feetao.web.vo.AddressVO;

public interface AddressService {

	/**
	 * 获取收货地址
	 * @param userId
	 * @param openId
	 * @return
	 */
	public List<AddressVO> getAddressList(Long userId , String openId);

	/**
	 * 获取单收货地址
	 * @param userId
	 * @param openId
	 * @param addressId
	 * @return
	 */
	public AddressVO getAddressById(Long userId , String openId , Long addressId);
	
	/**
	 * 获取默认地址
	 * @param userId
	 * @param openId
	 * @return
	 */
	public AddressVO getDefaultAddress(Long userId , String openId);
	
	/**
	 * 添加收货地址
	 * @param userId
	 * @param openId
	 * @param vo
	 */
	public AddressVO addAddress(Long userId , String openId , String name , String mobile , String address);
	
	/**
	 * 更新收货地址
	 * @param userId
	 * @param openId
	 */
	public void updateAddress(Long userId , String openId , Long id , String name , String mobile , String address);

	/**
	 * 设置默认地址
	 * @param userId
	 */
	public void setAddress(Long userId , String openId , Long id);
	
	/**
	 * 删除收货地址
	 * @param userId
	 * @param openId
	 */
	public void removeAddress(Long userId , String openId , Long id);
	
}
