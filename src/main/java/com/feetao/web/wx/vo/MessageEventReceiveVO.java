package com.feetao.web.wx.vo;

import org.dom4j.Element;

public class MessageEventReceiveVO extends MessageReceiveVO {
	
	private String event;
	
	private String eventKey;

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	@Override
	public void setProperties(Element root) {
		super.setProperties(root);
		this.event	 = root.element("Event").getTextTrim();
		this.eventKey = root.element("EventKey").getTextTrim();
	}
	
	@Override
	public String toString() {
		return "MessageEventReceiveVO [event=" + event + ", eventKey="
				+ eventKey + "]";
	}
	
}
