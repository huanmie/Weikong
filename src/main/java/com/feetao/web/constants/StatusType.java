package com.feetao.web.constants;

public class StatusType {

	/**
	 * 编辑状态
	 */
	public static byte OFFLINE	= 0;
	
	/**
	 * 发布状态
	 */
	public static byte ONLINE	= 1;
	
	/**
	 * 订单创建
	 */
	public static byte ORDER_CREATE	= 6;
	
	/**
	 * 订单取消
	 */
	public static byte ORDER_CANCEL	= 7;
	
	/**
	 * 订单发货
	 */
	public static byte ORDER_SEND	= 8;
	
	/**
	 * 不满退货
	 */
	public static byte ORDER_FAILED = 9;
	
	/**
	 * 交易成功
	 */
	public static byte ORDER_SUCCESS = 10;

	/**
	 * 删除状态
	 */
	public static byte REMOVED	= 30;
	
	
}
