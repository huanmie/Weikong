package com.feetao.web.model;

import java.io.Serializable;


/**
 * 用户信息
 * @author feetao
 */
public class UserDO extends BaseDO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID 主键
	 */
	private Long userId;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * MD5秘钥
	 */
	private String salt;
	
	/**
	 * 电话
	 */
	private String mobile;

	/**
	 * 电子邮件
	 */
	private String email;
	
	/**
	 * QQ号
	 */
	private String qq;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
	
}
