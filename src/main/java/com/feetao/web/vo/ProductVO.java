package com.feetao.web.vo;

public class ProductVO {
	/**
	 * 主键ID
	 */
	private Long id;

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 缩略图
	 */
	private String thumbnail;

	/**
	 * 原图
	 */
	private String picture;
	
	/**
	 * 价格
	 */
	private Long price;

	/**
	 * 单位
	 */
	private String unit;

	/**
	 * 销量
	 */
	private Integer sales;
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public Integer getSales() {
		return sales;
	}
	
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	
	public String getDotPrice() {
		return String.format("%.2f", (double)price/100);
	}

}
