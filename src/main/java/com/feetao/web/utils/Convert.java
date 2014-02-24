package com.feetao.web.utils;

import org.springframework.beans.BeanUtils;

public class Convert {

	public static <T> T convert(Class<T> cla , Object obj) {
		try {
			T t = cla.newInstance();
			BeanUtils.copyProperties(obj,t);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
