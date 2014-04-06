package com.feetao.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.feetao.web.constants.StatusType;
import com.feetao.web.model.ItemDO;

public class ItemDao  extends SqlSessionDaoSupport {

	public List<ItemDO> getItemList(Long userId) {
		Map<String, Object> params = new HashMap<String , Object>();
		params.put("userId", userId);
		params.put("status", StatusType.ONLINE);
		return this.getSqlSession().selectList("item.getItemList", params);
	}
	
}
