package com.feetao.web.wx.vo;

import org.dom4j.Element;

public class MessageEventReceiveVO extends MessageReceiveVO {
	
	private String event;

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	@Override
	public void setProperties(Element root) {
		super.setProperties(root);
		this.event	 = root.element("Event").getTextTrim();
	}

	@Override
	public String toString() {
		return "MessageEventReceiveVO [event=" + event + "]";
	}
	
}
