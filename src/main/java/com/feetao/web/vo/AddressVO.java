package com.feetao.web.vo;

public class AddressVO {

	/**
	 * 主键ID
	 */
	private Long id;

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * openId
	 */
	private String openId;

	/**
	 * 名字
	 */
	private String name;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 地址
	 */
	private String address;
	
	/**
	 * 默认
	 */
	private Byte addrStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Byte getAddrStatus() {
		return addrStatus;
	}

	public void setAddrStatus(Byte addrStatus) {
		this.addrStatus = addrStatus;
	}

	@Override
	public String toString() {
		return "AddressVO [id=" + id + ", userId=" + userId + ", openId="
				+ openId + ", name=" + name + ", mobile=" + mobile
				+ ", address=" + address + "]";
	}

	
}
