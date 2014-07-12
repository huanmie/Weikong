package com.feetao.web.vo;

public class ShopVO {
	/**
	 * 主键ID
	 */
	private Long id;
	
	/**
	 * 用户ID
	 */
	private Long userId;
	
	/**
	 * 分类key
	 */
	private String item;
	
	/**
	 * 链接
	 */
	private String url;
	
	/**
	 * 名字
	 */
	private String name;

	/**
	 * 类别图片
	 */
	private String picture;
	
	/**
	 * 类别描述
	 */
	private String address;
	
	/**
	 * 电话
	 */
	private String mobile;
	
	/**
	 * 送货地址
	 */
	private Long sendPrice;
	
	/**
	 * 营业时间
	 */
	private String businessTime;

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

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getSendPrice() {
		return sendPrice;
	}

	public void setSendPrice(Long sendPrice) {
		this.sendPrice = sendPrice;
	}

	public String getBusinessTime() {
		return businessTime;
	}

	public void setBusinessTime(String businessTime) {
		this.businessTime = businessTime;
	}
	
}
