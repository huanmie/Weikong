package com.feetao.web.wx.vo;

import org.dom4j.Element;

public class MessageLocationReceiveVO extends MessageReceiveVO {

	private String locationX;
	
	private String locationY;
	
	private String scale;
	
	private String label;
	
	private String msgId;

	public String getLocationX() {
		return locationX;
	}

	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}

	public String getLocationY() {
		return locationY;
	}

	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	@Override
	public void setProperties(Element root) {
		super.setProperties(root);
		this.locationX	 	= root.element("Location_X").getTextTrim();
		this.locationY 		= root.element("Location_Y").getTextTrim();
		this.scale 			= root.element("Scale").getTextTrim();
		this.label			= root.element("Label").getTextTrim();
		this.msgId	 		= root.element("MsgId").getTextTrim();
	}

}
