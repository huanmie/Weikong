package com.feetao.web.model;

import java.io.Serializable;
import java.util.Date;


/**
 * 微信留言消息
 * @author feetao
 */
public class MessageDO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Long id;
	
	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 关注者唯一ID
	 */
	private String openId;
	
	/**
	 * 留言内容
	 */
	private String content;

	/**
	 * 状态
	 */
	private Byte status;
	
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	
	/**
	 * 更新时间
	 */
	private Date gmtModified;
	
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

}
