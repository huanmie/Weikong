package com.feetao.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.feetao.web.dao.ItemDao;
import com.feetao.web.model.ItemDO;
import com.feetao.web.service.ItemService;
import com.feetao.web.utils.Convert;
import com.feetao.web.vo.ItemVO;

public class ItemServiceImpl implements ItemService {

	@Resource
	private ItemDao itemDao;
	
	@Override
	public List<ItemVO> getItemList(Long userId) {
		List<ItemDO> list = itemDao.getItemList(userId);
		if(list != null && list.size() > 0) {
			ArrayList<ItemVO> result = new ArrayList<ItemVO>();
			for(int i = 0 ; i < list.size() ; i++)
				result.add(Convert.convert(ItemVO.class , list.get(i)));
			return result;
		}
		return null;
	}

}
