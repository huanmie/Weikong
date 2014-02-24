package com.feetao.web.model;

import java.io.Serializable;

public class BasePlugin implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String plugin;

	public String getPlugin() {
		return plugin;
	}

	public void setPlugin(String plugin) {
		this.plugin = plugin;
	}
	
}
